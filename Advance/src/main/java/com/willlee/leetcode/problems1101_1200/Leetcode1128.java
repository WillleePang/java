package com.willlee.leetcode.problems1101_1200;

import java.util.Arrays;

public class Leetcode1128 {
	public int numEquivDominoPairs(int[][] dominoes) {
		int ans = 0;
		int[] cp = new int[100];
		for (int[] arr : dominoes) {
			Arrays.parallelSort(arr);
			ans += cp[arr[0] * 10 + arr[1]]++;
		}
		return ans;
	}

	public static void main(String[] args) {
		Leetcode1128 a = new Leetcode1128();
		a.numEquivDominoPairs(new int[][] { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } });
	}
}
