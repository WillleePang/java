package com.willlee.leetcode.problems1201_1300;

public class Leetcode1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.min(m, n);
        boolean[][][] dp = new boolean[m][n][len];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = (matrix[i][j] == 1);
                count += dp[i][j][0] ? 1 : 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < len; k++) {
                    dp[i][j][k] = (matrix[i][j] == 1 && dp[i - 1][j][k - 1] && dp[i][j - 1][k - 1]
                            && dp[i - 1][j - 1][k - 1]);
                    if (dp[i][j][k]) {
                        count++;
                    }
                }
            }
        }
        return count;

    }

    // 那么基于此，我们就可以将原始的dp降一维度，设dp[i][j]表示以(i, j)为右下角的最大全1正方形区域的边长，则有如下状态转移方程：
    // dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j -
    // 1]) + 1;
    public int countSquares1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int ans = 0;
        // 预处理每一行和每一列
        for (int i = 0; i < m; i++) {
            ans += dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            ans += dp[0][j] = matrix[0][j];
        }

        if (matrix[0][0] == 1) {
            ans--;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
}
