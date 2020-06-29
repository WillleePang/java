package com.willlee.leetcode.problems301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode368 {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int[] lengths = new int[nums.length];
		int[] lasts = new int[nums.length];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int length = -1;
			int last = -1;
			for (int j = i - 1; j >= 0; j--) {// 不断往前比，如果发现能找到被当前数整除的数，且长度最长，记录上一个数的坐标跟长度
				if (nums[i] % nums[j] == 0 && lengths[j] + 1 > length) {
					length = lengths[j] + 1;
					last = j;
				}
			}
			// 如果找不到设置为1
			lengths[i] = length == -1 ? 1 : length;
			// 如果找不到设置为当前数
			lasts[i] = last == -1 ? i : last;
		}
		int max = -1;
		int index = -1;
		for (int i = 0; i < lengths.length; i++) {
			if (lengths[i] > max) {
				max = lengths[i];
				index = i;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < max; i++) {
			result.add(nums[index]);
			index = lasts[index];
		}
		return result;
	}
}
