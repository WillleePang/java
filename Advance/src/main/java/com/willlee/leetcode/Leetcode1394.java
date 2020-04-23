package com.willlee.leetcode;

public class Leetcode1394 {

    public int findLucky(int[] arr) {
        int[] a = new int[501];
        for (int i = 0; i < arr.length; i++) {
            a[arr[i]]++;
        }
        for (int i = arr.length; i > 0; i--) {
            if (a[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode1394 a = new Leetcode1394();
        a.findLucky(new int[] { 2, 2, 2, 3, 3 });
    }
}
