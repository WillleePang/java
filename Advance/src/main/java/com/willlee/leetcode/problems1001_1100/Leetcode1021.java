package com.willlee.leetcode.problems1001_1100;

import java.util.Stack;

public class Leetcode1021 {

    public String removeOuterParentheses1(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')')
                --level;
            if (level >= 1)
                sb.append(c);
            if (c == '(')
                ++level;
        }
        return sb.toString();
    }

    public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int start = 0;
        int end = 0;
        boolean flag = false;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                if (!flag) {// 遇到的第一个左括号，是原语的开始位置，记录下原语开始位置
                    start = i;
                    flag = true;
                }
            }
            if (ch == ')') {
                stack.pop();
                if (stack.isEmpty()) {// 当栈空的时候，找到了一个完整的原语
                    end = i;
                    ans.append(S.substring(start + 1, end));// 去掉原语的最外层括号，并追加到答案中
                    flag = false;
                    start = end;
                }
            }
        }
        return ans.toString();
    }
}
