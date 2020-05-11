package com.willlee.leetcode.problems1_100;

import java.util.Arrays;

import com.willlee.leetcode.utils.ArrayUtil;

//leetcode31
//思路：从末尾循环找到，连续的两个数a[i]和a[j]，且a[i]<a[j]，然后对j~length-1升序排列，然后第一个数字与a[i]对调
public class Leetcode31 {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1])
                break;
        }
        if (i != 0) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            for (int j = i; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] < nums[j]) {
                        int temp = nums[k];
                        nums[k] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        } else {
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3 };
        nextPermutation(a);
        ArrayUtil.print(a);
    }
}
