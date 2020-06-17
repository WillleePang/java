package com.willlee.leetcode.problems1_100;

public class Leetcode91 {
	public static void main(String[] args) {
		Leetcode91 a = new Leetcode91();
		int numDecodings = a.numDecodings("0");
		System.out.println(numDecodings);
	}

	public int numDecodings(String s) {
		if ("0".equals(s) || s.charAt(0) == '0') {
			return 0;
		}
		// dp[i]表示到字符串s下标i处时最多有几种解码方式
		int[] dp = new int[s.length()];
		// 动态方程
		if (s.charAt(0) != '0') {
			dp[0] = 1;
		}
		for (int i = 1; i < s.length(); i++) {
			// 无法解析的情况
			if (s.charAt(i) == '0' && (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0')) {
				return 0;
				// 当前后2位是10或20
			} else if (s.charAt(i) == '0' && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')) {
				if (i > 1) {
					dp[i] = dp[i - 2];
				} else {
					dp[i] = 1;
				}
				// 当前后2位是21-26或11-19
			} else if ((s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) <= '6')
					|| (s.charAt(i - 1) == '1')) {
				if (i > 1) {
					dp[i] = dp[i - 1] + dp[i - 2];
				} else {
					dp[i] = dp[i - 1] + 1;
				}
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[s.length() - 1];
	}
}
