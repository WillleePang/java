package com.willlee.leetcode.array;

import java.util.Arrays;

//leetcode719
public class SmallestDistancePair {
    // 转换思路，我们先对数组排序，我们知道排序后，距离一定在 0 ~ nums[len(nums)-1] - nums[0]之间
    // 然后我们在这个区间枚举距离d，看对于每个d，有多少对数字的距离（假设为count个） <= d，如果
    // count大于k了，这个距离肯定不是要求的距离，然后我们缩小范围，这里可以采用二分的思想求距离d。

    // 求count， 采用双指针法 总共遍历n+j次 for i in range(1，n) 以每个nums[i]为较大数,
    // 判断可以产生多少个小于等于mid的距离，把它们累加起来即可 具体做法： 如果对于每个i，如果能得到 j为起始坐标，刚好满足nums[i] -
    // nums[j] <=mid, 那么对于nums[i], 有（i - j）个距离对符合要求。（因为是刚好满足，所以对于下标小于j的数字
    // ，与nums[i]的距离会增大，就大于mid了）

    // 这里注意，对于每个nums[i]，j无需从头遍历，因为nums[i]-nums[j]<= mid的首尾下标i,j是刚好满足条件时的值，
    // 那么我们得到nums[i]-nums[j-1]肯定不满足条件，即nums[i] - nums[j-1] > mid，
    // 那么nums[i+1]-nums[j-1]距离只会更大，所以只需要判断nums[i+1]-nums[j]能否满足条件了。
    // 所以找count的时间复杂度为O(len(nums)+max(j))， max(j)为i=
    // nums[n-1]时，刚好满足条件nums[n-1]-nums[j]<=mid时的下标j。

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mid)
                    left++;
                count += right - left;
            }
            // count = number of pairs with distance <= mi
            if (count >= k)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
