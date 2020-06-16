package com.willlee.leetcode.problems1_100;

import java.util.Stack;

public class Leetcode32 {
    public static void main(String[] args) {
        Leetcode32 a = new Leetcode32();
        a.longestValidParentheses2("()(()");
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParentheses1(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isVaild(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    private boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
