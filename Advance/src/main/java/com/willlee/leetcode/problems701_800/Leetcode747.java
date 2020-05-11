package com.willlee.leetcode.problems701_800;

//leetcode747
public class Leetcode747 {
    public int dominantIndex(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        if (max1 >= max2 * 2) {
            return index;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 0, 0, 3, 2 };
        Leetcode747 b = new Leetcode747();
        b.dominantIndex(a);
    }
}
