package com.willlee.leetcode.problems801_900;

import java.util.Stack;

public class Leetcode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            stack.clear();
            for (int j = 0; j < A[i].length; j++) {
                stack.add(A[i][j]);
            }
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = stack.pop() ^ 1;
            }
        }
        return A;
    }

    public int[][] flipAndInvertImage1(int[][] A) {
        int C = A[0].length;
        for (int[] row : A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        return A;
    }
}
