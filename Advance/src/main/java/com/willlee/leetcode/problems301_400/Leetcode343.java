package com.willlee.leetcode.problems301_400;

public class Leetcode343 {
	public int integerBreak(int n) {
		if (n == 2)
			return 1;
		int res = -1;
		for (int i = 1; i < n - 1; i++) {
			res = Math.max(res, Math.max(i * (n - i), i * integerBreak(n - i)));
		}
		return res;
	}

	int[] memory;

	public int integerBreak1(int n) {
		memory = new int[n + 1];
		return integerBreakHelper(n);
	}

	public int integerBreakHelper(int n) {
		if (n == 2)
			return 1;
		if (memory[n] != 0)
			return memory[n];
		int res = -1;
		for (int i = 1; i < n - 1; i++) {
			res = Math.max(res, Math.max(i * (n - i), i * integerBreakHelper(n - i)));
		}
		memory[n] = res;
		return res;
	}

	public int integerBreak3(int n) {
		memory[2] = 1;
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j <= i - 1; j++) {
				memory[i] = Math.max(memory[i], Math.max(j * memory[i - j], j * (i - j)));
			}
		}
		return memory[n];
	}
}
