package com.willlee.leetcode.problems901_1000;

import java.util.Stack;

public class Leetcode962 {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[stack.peek()])
                stack.push(i);
        }
        int res = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int l = i;
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                l = stack.pop();
            }
            res = Math.max(res, i - l);
        }
        return res;
    }
}
