package com.willlee.leetcode.array;

//leetcode59
public class GenerateMatrix {
    public int[][] generateMatrix1(int n) {
        if (n == 0) {
            return null;
        }
        int[][] m = new int[n][n];
        int n1 = 1;
        int i = 0;
        int j = 0;
        int a = 0;
        int b = 1;
        while (n1 <= n * n) {
            m[i][j] = n1;
            n1++;
            if (m[Math.abs(i + a) % n][Math.abs(j + b) % n] != 0) {
                int temp = a;
                a = b;
                b = 0 - temp;
            }
            i += a;
            j += b;
        }
        return m;
    }

    public int[][] generateMatrix2(int n) {
        int[][] result = new int[n][n];

        int start = 0, end = n - 1, x = 1;
        while (start < end) {
            for (int i = start; i < end; i++) {
                result[start][i] = x++;
            }
            for (int i = start; i < end; i++) {
                result[i][end] = x++;
            }
            for (int i = end; i > start; i--) {
                result[end][i] = x++;
            }
            for (int i = end; i > start; i--) {
                result[i][start] = x++;
            }
            start++;
            end--;
        }
        if (start == end)
            result[start][start] = x;

        return result;
    }
}
