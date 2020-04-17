package com.willlee.leetcode;

public class Leetcode1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int a = maxFunc(A, L, M);
        int b = maxFunc(A, M, L);
        return Math.max(a, b);
    }

    public int maxFunc(int[] A, int L, int M) {
        if (L + M > A.length) {
            return -1;
        }
        int i, j;
        int max = 0;
        int ret1 = 0;
        // 求前L个的和
        for (i = 0; i < L - 1; i++) {
            ret1 += A[i];
        }
        // 第一层循环，滑动L条
        for (; i < A.length - M; i++) {
            ret1 += A[i];
            // 第二层循环滑动M条
            int ret2 = 0;
            for (j = i + 1; j < i + M; j++) {
                ret2 += A[j];
            }
            for (; j < A.length; j++) {
                ret2 += A[j];
                max = Math.max(max, ret1 + ret2);
                ret2 -= A[j - (M - 1)];
            }
            ret1 -= A[i - (L - 1)];
        }
        return max;
    }
}
