package com.willlee.leetcode.array;

//leetcode80
public class RemoveDuplicates2 {
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }
}
