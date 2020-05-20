package com.willlee.leetcode.problems701_800;

import java.util.Stack;

public class Leetcode739 {
    public static void main(String[] args) {
        Leetcode739 a = new Leetcode739();
        a.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
    }

    public int[] dailyTemperatures1(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j += ans[j]) {
                if (T[i] < T[j]) {
                    ans[i] = j - i;
                    break;
                } else if (ans[j] == 0) {
                    ans[i] = 0;
                    break;
                }
            }
        }
        return ans;
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
