package com.willlee.leetcode.problems1_100;

//leetcode27
public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        int tag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[tag++] = nums[i];
        }
        return tag;
    }
}
