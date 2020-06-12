package com.willlee.leetcode.problems401_500;

public class Leetcode494 {
    public static void main(String[] args) {
        Leetcode494 a = new Leetcode494();
        int findTargetSumWays = a.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3);
        System.out.println(findTargetSumWays);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    int ans = 0;

    public int findTargetSumWays1(int[] nums, int S) {
        help(0, 0, nums, S);
        return ans;
    }

    private void help(int index, int sum, int[] nums, int S) {
        if (index == nums.length) {
            if (sum == S)
                ans++;
        } else {
            help(index + 1, sum + nums[index], nums, S);
            help(index + 1, sum - nums[index], nums, S);
        }
    }
}
