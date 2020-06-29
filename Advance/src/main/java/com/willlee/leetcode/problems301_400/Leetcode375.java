package com.willlee.leetcode.problems301_400;

public class Leetcode375 {
	public int getMoneyAmount(int n) {
		return recursion(1, n);
	}

	public int recursion(int start, int end) {
		if (start == end)
			return 0;
		int res = Integer.MAX_VALUE, max = 0, left = 0, right = 0;
		for (int i = start; i <= end; i++) {
			if (i - 1 >= start)
				left = recursion(start, i - 1);
			if (i + 1 <= end)
				right = recursion(i + 1, end);
			max = i + Math.max(left, right);
			res = Math.min(res, max);
		}
		return res;
	}

	public static int getMoneyAmountWithDP(int n) {
		if (n == 1)
			return 0;
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = i - 1; j > 0; j--) {
				int min = Integer.MAX_VALUE, left = 0, right = 0;
				for (int k = i; k > j - 1; k--) {
					left = (k == j || j == k - 1) ? -1 : dp[k - 1][j];
					right = (k == i || i == k + 1) ? -1 : dp[i][k + 1];
					min = (left == -1 && right == -1) ? k : Math.min(min, k + Math.max(left, right));
				}
				dp[i][j] = min;
			}
		}
		return dp[n][1];
	}
}
