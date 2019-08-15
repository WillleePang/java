package com.willlee.leetcode.array;

import java.util.Arrays;

//leetcode561
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i + 1) % 2 == 0) {
                continue;
            } else {
                sum += nums[i];
            }
        }
        return sum;
    }
}
