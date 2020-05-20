package com.willlee.leetcode.problems701_800;

import java.util.Stack;

public class Leetcode735 {
    public static void main(String[] args) {
        Leetcode735 a = new Leetcode735();
        a.asteroidCollision(new int[] { -2, 2, 1, -2 });
    }

    public int[] asteroidCollision1(int[] asteroids) {
        int[] res = new int[asteroids.length];
        int index = -1;
        for (int i = 0; i < asteroids.length; i++) {
            int val = asteroids[i];
            if (index == -1 || res[index] * val > 0 || val > 0) {
                res[++index] = val;
            } else if (val < 0) {
                if (res[index] + val < 0) {
                    index--;
                    i--;
                } else if (res[index] + val == 0) {
                    index--;
                }
            }
        }
        int[] ans = new int[index + 1];
        for (int i = 0; i <= index; i++) {
            ans[i] = res[i];
        }
        return ans;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            boolean flag = false;
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                Integer preAst = stack.pop();
                if (Math.abs(preAst) != Math.abs(ast)) {
                    ast = Math.abs(preAst) > Math.abs(ast) ? preAst : ast;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                stack.push(ast);
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
