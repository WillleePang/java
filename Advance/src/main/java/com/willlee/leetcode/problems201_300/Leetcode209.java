package com.willlee.leetcode.problems201_300;

//leetcode209
public class Leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }
}
