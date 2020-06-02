package com.willlee.leetcode.problems101_200;

public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int b : nums) {
            a ^= b;
        }
        return a;
    }
}
