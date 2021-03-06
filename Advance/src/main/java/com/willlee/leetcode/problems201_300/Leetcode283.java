package com.willlee.leetcode.problems201_300;

//leetcode283
public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[offset++] = nums[i];
            }
        }
        for (int i = offset; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
