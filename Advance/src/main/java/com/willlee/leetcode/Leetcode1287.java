package com.willlee.leetcode;

public class Leetcode1287 {
    public int findSpecialInteger(int[] arr) {
        int std = (int) (arr.length * 0.25);
        for (int i = 0; i < arr.length - std; i++) {
            if (arr[i] == arr[i + std]) {
                return arr[i];
            }
        }
        return 0;
    }
}
