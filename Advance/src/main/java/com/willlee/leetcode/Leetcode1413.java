package com.willlee.leetcode;

public class Leetcode1413 {
    public int minStartValue(int[] nums) {
        int min = nums[0];
        int temp = min;
        for (int i = 1; i < nums.length; i++) {
            temp += nums[i];
            if (temp < min) {
                min = temp;
            }
        }
        if (min > 0) {
            return 1;
        } else {
            return 1 - min;
        }
    }
}
