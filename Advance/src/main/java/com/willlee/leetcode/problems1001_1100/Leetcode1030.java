package com.willlee.leetcode.problems1001_1100;

import java.util.Arrays;

public class Leetcode1030 {
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i * C + j;
                re[t][0] = i;
                re[t][1] = j;
            }
        }
        Arrays.sort(re, (arr1, arr2) -> {
            int d1 = Math.abs(arr1[0] - r0) + Math.abs(arr1[1] - c0);
            int d2 = Math.abs(arr2[0] - r0) + Math.abs(arr2[1] - c0);
            return Integer.compare(d1, d2);
        });
        return re;
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        ans[0] = new int[] { r0, c0 };
        int m = 0, k = 0;
        while (++m <= (R - r0 + C - c0 - 2) || m <= (R - r0 + c0 - 1) || m <= (r0 + c0) || m <= (r0 + C - c0 - 1))
            for (int i = -m; i <= m; i++)
                for (int j = m - Math.abs(i), count = 0 == j ? 1 : 0; count < 2; count++, j *= -1)
                    if (r0 + i < R && r0 + i >= 0 && c0 + j < C && c0 + j >= 0)
                        ans[++k] = new int[] { r0 + i, c0 + j };
        return ans;
    }

}
