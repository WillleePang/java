package com.willlee.leetcode.problems401_500;

//leetcode485
public class Leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                b++;
            } else {
                a = Math.max(a, b);
                b = 0;
            }
        }
        a = Math.max(a, b);
        return a;
    }
}
