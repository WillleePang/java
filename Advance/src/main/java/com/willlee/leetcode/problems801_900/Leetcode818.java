package com.willlee.leetcode.problems801_900;

public class Leetcode818 {
    public int racecar(int target) {
        int[] suport = new int[target + 1];
        int res = dp(target, suport);
        return res;
    }

    public int dp(int target, int[] support) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 4;
        }
        if (support[target] != 0) {
            return support[target];
        }

        int n = 0;
        // log2(t+1)获得幂数n
        for (int i = 0; i < target; i++) {
            if ((1 << i) > target) {
                n = i;
                break;
            }
        }
        if (target + 1 == (1 << n)) {
            return n;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n - 1; ++j) {
            min = Math.min(min, dp((int) target - (1 << (n - 1)) + (1 << j), support) + n + j + 1);
        }
        support[target] = Math.min(min, dp((1 << (n)) - (target + 1), support) + n + 1);
        return support[target];
    }

    int[] dp = new int[10001];

    public int racecar1(int t) {
        if (dp[t] > 0)
            return dp[t];
        int n = (int) (Math.log(t) / Math.log(2)) + 1;
        if (1 << n == t + 1)
            dp[t] = n;
        else {
            dp[t] = racecar1((1 << n) - 1 - t) + n + 1;
            for (int m = 0; m < n - 1; ++m)
                dp[t] = Math.min(dp[t], racecar1(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
        }
        return dp[t];
    }
}
