package com.willlee.leetcode.array;

//leetcode643
public class FindMaxAverage {

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        int temp = sum;
        for (int i = 1; i + k - 1 < nums.length; ++i) {
            temp = temp + nums[i + k - 1] - nums[i - 1];
            if (temp > sum)
                sum = temp;
        }
        return sum / (double) k;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 0, 4, 0, 3, 2 };
        findMaxAverage(a, 1);
    }
}
