package com.willlee.leetcode;

public class Leetcode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int max_save = 0;
        int curr_save = 0;
        int satisf = 0;
        for (int i = 0; i < n; i++) {
            satisf += grumpy[i] == 0 ? customers[i] : 0;
            curr_save += customers[i] * grumpy[i];
            if (i >= X - 1) {
                max_save = Math.max(curr_save, max_save);
                curr_save -= customers[i - X + 1] * grumpy[i - X + 1];
            }
        }
        return satisf + max_save;
    }
}
