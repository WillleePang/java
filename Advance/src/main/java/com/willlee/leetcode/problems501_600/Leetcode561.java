package com.willlee.leetcode.problems501_600;

import java.util.Arrays;

//leetcode561
public class Leetcode561 {
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
