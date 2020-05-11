package com.willlee.leetcode.problems701_800;

//leetcode724
public class Leetcode724 {
    public int pivotIndex1(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int num : nums)
            sum += num;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == leftSum * 2) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}
