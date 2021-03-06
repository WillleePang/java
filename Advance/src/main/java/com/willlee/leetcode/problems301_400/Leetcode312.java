package com.willlee.leetcode.problems301_400;

public class Leetcode312 {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = new_nums[n - 1] = 1;
        int[][] memo = new int[n][n];

        return dp(memo, new_nums, 0, n - 1);
    }

    private int dp(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right)
            return 0;
        if (memo[left][right] > 0)
            return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans,
                    nums[left] * nums[i] * nums[right] + dp(memo, nums, left, i) + dp(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }

    public int maxCoins1(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = new_nums[n - 1] = 1;
        int[][] dp = new int[n][n];
        for (int left = n - 2; left > -1; left--) {
            for (int right = left + 2; right < n; right++) {
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            new_nums[left] * new_nums[i] * new_nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
