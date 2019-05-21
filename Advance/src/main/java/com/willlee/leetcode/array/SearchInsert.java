package com.willlee.leetcode.array;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        else
            return rank(nums, 0, nums.length - 1, target);
    }

    public int rank(int[] nums, int pHead, int pTail, int value) {
        if (pHead > pTail)
            return pHead;
        else {
            int pMid = pHead + (pTail - pHead) / 2;
            if (value > nums[pMid])
                return rank(nums, pMid + 1, pTail, value);
            else if (value < nums[pMid])
                return rank(nums, pHead, pMid - 1, value);
            else
                return pMid;
        }
    }

    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }
}
