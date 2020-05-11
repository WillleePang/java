package com.willlee.leetcode.problems101_200;

//leetcode153 154
public class Leetcode153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;//取中间位置
            if (nums[mid] == nums[left]) {
                // 可能是递增的序列
                min = Math.min(min, nums[left]);
                left++;
            } else if (nums[mid] > nums[left]) {
                // 有序的
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid;
            }
        }
        if (left != nums.length) {
            min = Math.min(min, nums[left]);
        }
        return min;
    }
}
