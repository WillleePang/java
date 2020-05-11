package com.willlee.leetcode.problems1_100;

//leetcode55
public class Leetcode55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0 && !reachZeroNext(nums, i)) {
                return false;
            }
        }
        return true;

    }

    private boolean reachZeroNext(int[] nums, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] >= (i - j + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;

    }
}
