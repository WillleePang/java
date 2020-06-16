package com.willlee.leetcode.problems301_400;

public class Leetcode303 {
	public static void main(String[] args) {
		NumArray a = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(a.sumRange(0, 2));
		System.out.println(a.sumRange(2, 5));
		System.out.println(a.sumRange(0, 5));
	}
}

class NumArray {
	int[] sum;

	public NumArray(int[] nums) {
		if (nums.length > 0) {
			sum = new int[nums.length];
			sum[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sum[i] += sum[i - 1] + nums[i];
			}
		}
	}

	public int sumRange(int i, int j) {
		if (sum == null) {
			return -1;
		}
		if (i > 0) {
			return sum[j] - sum[i - 1];
		} else {
			return sum[j];
		}
	}
}