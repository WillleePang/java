package com.willlee.leetcode.problems1101_1200;

public class Leetcode1144 {
	public int movesToMakeZigzag(int[] nums) {
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[0] >= nums[1]) {
					count1 += (nums[0] - nums[1] + 1);
				}
			} else if (i == nums.length - 1) {
				if (nums[i] >= nums[i - 1]) {
					count1 += (nums[i] - nums[i - 1] + 1);
				}
			} else if (nums[i] >= Math.min(nums[i - 1], nums[i + 1])) {
				count1 += (nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
			}
		}
		for (int i = 1; i < nums.length; i += 2) {
			if (i == nums.length - 1) {
				if (nums[i] >= nums[i - 1]) {
					count2 += (nums[i] - nums[i - 1] + 1);
				}
			} else if (nums[i] >= Math.min(nums[i - 1], nums[i + 1])) {
				count2 += (nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
			}
		}
		return Math.min(count1, count2);
	}
}
