package com.willlee.leetcode.array;

public class ArrayUtil {
    public static void print(int[] a) {
        if (a == null || a.length == 0)
            return;
        int i = 0;
        while (i < a.length) {
            i++;
            if (i != a.length)
                System.out.print(a[i-1] + " ");
            else
                System.out.println(a[i-1]);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 3, 5, 7, 9 };
        print(a);
    }
}
