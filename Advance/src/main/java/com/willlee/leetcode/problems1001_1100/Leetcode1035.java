package com.willlee.leetcode.problems1001_1100;

public class Leetcode1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        int[] A = new int[] { 2, 5, 1, 2, 5 };
        int[] B = new int[] { 10, 5, 2, 1, 5, 2 };
        Leetcode1035 a = new Leetcode1035();
        a.maxUncrossedLines(A, B);
    }
}
