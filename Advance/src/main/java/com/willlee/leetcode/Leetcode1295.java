package com.willlee.leetcode;

public class Leetcode1295 {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i : nums) {
            if (String.valueOf(i).length() % 2 == 0) {
                res++;
            }
        }
        return res;
    }
}
