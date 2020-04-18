package com.willlee.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode15
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // 先给数组进行排序
        Arrays.sort(nums);
        // 定一个数x，用两个指针指向数组中在它后面的元素的开始和结尾，向中间遍历
        for (int k = 0; k < nums.length - 2; k++) {
            if (!list.isEmpty() && nums[k] == nums[k - 1]) { // 去重条件 重点
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            int sum = 0 - nums[k];
            while (i < j) {
                if (nums[i] + nums[j] == sum) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[k]);
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list.add(list1);
                    i++;
                    j--;
                    // 如果两个数字相同，我们直接跳到下一个循环。
                    while (nums[i] == nums[i - 1] && i < j) {
                        i++;
                    }
                    // 如果两个数字相同，我们直接跳到下一个循环。
                    while (nums[j] == nums[j + 1] && i < j) {
                        j--;
                    }
                } else if (nums[i] + nums[j] < sum && i < j) {
                    // 如果后面两数相加小于target，说明左边还得往右移
                    i++;
                    continue;
                } else {
                    // 如果后面两数相加大于target，说明右边就要往左移
                    j--;
                    continue;
                }
            }
        }
        return list;
    }
}
