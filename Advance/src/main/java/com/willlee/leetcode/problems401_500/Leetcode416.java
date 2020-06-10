package com.willlee.leetcode.problems401_500;

public class Leetcode416 {
    public static void main(String[] args) {
        Leetcode416 a = new Leetcode416();
        a.canPartition(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxValue = Math.max(maxValue, nums[i]);
        }
        if (sum % 2 != 0 || maxValue > (sum / 2)) {
            return false;
        }
        int target = sum / 2;
        return backTrack(nums, target, 0, nums.length - 1);
    }

    private boolean backTrack(int[] nums, int target, int curSum, int start) {
        if (curSum == target)
            return true;
        for (int i = start; i >= 0; i--) {
            if (curSum + nums[i] <= target) {
                if (backTrack(nums, target, curSum + nums[i], i - 1))
                    return true;
            }
        }
        return false;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // 建立dp数组，dp[i]表示能否找到和为i的数组元素集合
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num] == true) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}
