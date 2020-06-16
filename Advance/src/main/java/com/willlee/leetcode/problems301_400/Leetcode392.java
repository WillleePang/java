package com.willlee.leetcode.problems301_400;

public class Leetcode392 {
	public boolean isSubsequence(String s, String t) {
		char[] a = s.toCharArray();
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			index = t.indexOf(a[i], index + 1);
			if (index == -1) {
				return false;
			}
		}
		return true;
	}
}
