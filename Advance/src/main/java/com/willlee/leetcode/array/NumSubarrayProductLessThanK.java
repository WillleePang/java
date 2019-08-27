package com.willlee.leetcode.array;

//leetcode713
public class NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int prod = 1, left = 0, cnt = 0;

        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 10, 20, 30, 40 };
        int left = 0;
        System.out.println(a[left++]);
        System.out.println(left);
    }
}
