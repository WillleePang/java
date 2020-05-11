package com.willlee.leetcode.problems1301_1400;

public class Leetcode1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                ans[i] = i + 1;
                ans[i + n / 2] = -i - 1;
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                ans[i] = i + 1;
                ans[i + n / 2 + 1] = -i - 1;
            }
            ans[n / 2] = 0;
        }
        return ans;
    }
}
