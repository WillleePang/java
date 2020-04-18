package com.willlee.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode268
public class MissingNumber {
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        // 判断 n 是否出现在末位
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int exceptedNumCount = nums.length + 1;
        for (int i = 0; i < exceptedNumCount; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber3(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums)
            actualSum += num;
        return expectedSum - actualSum;
    }
}
