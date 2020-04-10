package com.willlee.leetcode;

import java.util.Arrays;

public class Leetcode945 {
    // 逻辑：先排序，再依次遍历数组元素，若当前元素小于等于它前一个元素，则将其变为前一个数 +1。
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int move = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
        }
        return move;
    }
    
    
}
