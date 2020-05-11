package com.willlee.leetcode.problems1201_1300;

public class Leetcode1299 {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
            } else {
                int j = i + 1;
                int max = arr[j];
                for (; j < arr.length; j++) {
                    max = Math.max(max, arr[j]);
                }
                arr[i] = max;
            }
        }
        return arr;
    }

    public int[] replaceElements1(int[] arr) {
        int length = arr.length;
        int[] sum = new int[length];
        sum[length - 1] = arr[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            sum[i] = Math.max(arr[i], sum[i + 1]);
        }
        for (int i = 0; i < length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
            } else {
                arr[i] = sum[i + 1];
            }
        }
        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        int rightMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int t = arr[i];
            arr[i] = rightMax;
            if (t > rightMax) {
                rightMax = t;
            }
        }
        return arr;
    }
}
