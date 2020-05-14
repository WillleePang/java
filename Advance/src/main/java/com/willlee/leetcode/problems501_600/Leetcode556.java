package com.willlee.leetcode.problems501_600;

import java.util.Arrays;

public class Leetcode556 {
    public static void main(String[] args) {
        Leetcode556 a = new Leetcode556();
        int nextGreaterElement = a.nextGreaterElement(230241);
        System.out.println(nextGreaterElement);
    }

    
    
    public int nextGreaterElement(int n) {
        String str = "" + n;
        n = str.length();
        char[] arr = str.toCharArray();
        int i;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }
        if (i == 0)
            return -1;
        for (int j = n - 1; j >= i; j--) {
            if (arr[j] > arr[i - 1]) {
                char temp = arr[j];
                arr[j] = arr[i - 1];
                arr[i - 1] = temp;
                break;
            }
        }
        Arrays.sort(arr, i, arr.length);
        long res = Long.parseLong(new String(arr));
        if (res > Integer.MAX_VALUE)
            return -1;
        return (int) res;
    }
}
