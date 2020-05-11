package com.willlee.leetcode.problems601_700;

//leetcode674
public class Leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
            } else {
                max = Math.max(curr, max);
                curr = 1;
            }
        }
        return Math.max(curr, max);
    }
}
