package com.willlee.leetcode.problems701_800;

//leetcode718
public class Leetcode718 {

    // 设 dp[i][j] 为 A[i:] 和 B[j:] 的最长公共前缀，那么答案就为所有 dp[i][j] 中的最大值
    // max(dp[i][j])。如果 A[i] == B[j]，那么状态转移方程为 dp[i][j] = dp[i + 1][j + 1] +
    // 1，否则状态转移方程为 dp[i][j] = 0。
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                    if (ans < memo[i][j])
                        ans = memo[i][j];
                }
            }
        }
        return ans;
    }
}
