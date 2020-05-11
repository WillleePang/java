package com.willlee.leetcode.problems1301_1400;

public class Leetcode1313 {
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            len += nums[i];
        }
        int[] ans = new int[len];
        int index = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            while (freq-- > 0) {
                ans[index++] = val;
            }
        }
        return ans;
    }
}
