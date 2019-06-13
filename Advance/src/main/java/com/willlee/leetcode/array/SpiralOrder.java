package com.willlee.leetcode.array;

import java.util.ArrayList;
import java.util.List;

//leetcode54
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int m = 0;
        int n = 0;
        int a = 0;
        int b = 1;
        int length1 = matrix.length;
        int length2 = matrix[0].length;
        for (int i = 0; i < length1 * length2; i++) {
            list.add(matrix[m][n]);
            matrix[m][n] = 0;
            // 改变方向，第一次从右往左走的时候，会越界一次，java的取余模式，会导致n+b%length2变成负数
            if (matrix[(m + a) % length1][Math.abs((n + b) % length2)] == 0) {
                int temp = a;
                a = b;
                b = 0 - temp;
            }
            m += a;
            n += b;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] s = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        spiralOrder(s);
    }
}
