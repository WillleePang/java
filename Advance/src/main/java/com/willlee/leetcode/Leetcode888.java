package com.willlee.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }

        int sumB = 0;
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }

        int delta = (sumB - sumA) / 2;

        Set<Integer> setB = new HashSet<Integer>();
        for (int x : B)
            setB.add(x);
        for (int x : A)
            if (setB.contains(x + delta))
                return new int[] { x, x + delta };
        return null;
    }
}
