package com.willlee.leetcode.problems901_1000;

public class Leetcode941 {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if (n < 3) {
            return false;
        }
        if (A[0] > A[1]) {
            return false;
        }
        if (A[n - 1] > A[n - 2]) {
            return false;
        }
        int peak = 0;
        for (int i = 1; i < n - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peak++;
            }
            if (A[i] == A[i - 1] || A[i] == A[i + 1]) {
                return false;
            }
        }

        if (peak == 1) {
            return true;
        } else {
            return false;
        }
    }
    // 我们从数组的最左侧开始扫描，直到找到第一个不满足 A[i] < A[i + 1] 的 i，那么 i 就是这个数组的最高点。如果 i = 0
    // 或者不存在这样的 i（即整个数组都是单调递增的），那么就返回 false。否则从 i 开始继续扫描，判断接下来的的位置 j 是否都满足 A[j]
    // > A[j + 1]，若都满足就返回 true，否则返回 false。

    public boolean validMountainArray1(int[] A) {
        int n = A.length;
        int i = 0;

        while (i + 1 < n && A[i] < A[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        while (i + 1 < n && A[i] > A[i + 1]) {
            i++;

        }
        return i == n - 1;
    }

}
