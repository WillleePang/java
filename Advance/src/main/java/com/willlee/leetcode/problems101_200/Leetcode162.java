package com.willlee.leetcode.problems101_200;

//leetcode162
public class Leetcode162 {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        } else {
            return search(nums, mid + 1, r);
        }
    }
}
