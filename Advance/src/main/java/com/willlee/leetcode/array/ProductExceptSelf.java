package com.willlee.leetcode.array;

//leetcode238
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int j = res.length - 1; j >= 0; j--) {
            res[j] *= k;
            k = k * nums[j];
        }
        return res;
    }
}
