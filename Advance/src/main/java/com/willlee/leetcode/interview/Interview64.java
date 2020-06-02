package com.willlee.leetcode.interview;

public class Interview64 {
    int res = 0;

    public int sumNums(int n) {
        @SuppressWarnings("unused")
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
