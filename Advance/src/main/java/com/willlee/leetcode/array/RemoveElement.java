package com.willlee.leetcode.array;

//leetcode27
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int tag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[tag++] = nums[i];
        }
        return tag;
    }
}
