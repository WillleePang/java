package com.willlee.leetcode.problems1301_1400;

public class Leetcode1385 {
    private int getCount(int num1, int[] arr2, int d) {
        for (int num2 : arr2) {
            if (Math.abs(num1 - num2) <= d) {
                return 0;
            }
        }
        return 1;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int num1 : arr1) {
            ans += getCount(num1, arr2, d);
        }
        return ans;
    }

}
