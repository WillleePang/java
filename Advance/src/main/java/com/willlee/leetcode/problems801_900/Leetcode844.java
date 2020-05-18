package com.willlee.leetcode.problems801_900;

import java.util.Stack;

public class Leetcode844 {
    public static void main(String[] args) {
        Leetcode844 a = new Leetcode844();
        boolean backspaceCompare = a.backspaceCompare1("y#fo##f", "y#f#o##f");
        System.out.println(backspaceCompare);
    }

    public boolean backspaceCompare(String S, String T) {
        return haha(S).equals(haha(T));
    }

    private String haha(String origin) {
        Stack<Character> stack = new Stack<>();
        for (char c : origin.toCharArray()) {
            if (!stack.isEmpty() && c == '#') {
                stack.pop();
            } else if (c != '#') {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            return sb.reverse().toString();
        } else {
            return "";
        }
    }

    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            i = getValidIndex(i, S);
            j = getValidIndex(j, T);
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }

    // 确定有效的index位置
    private int getValidIndex(int idx, String s) {
        int cnt = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                idx--;
                cnt++;
            } else if (cnt > 0) {
                idx--;
                cnt--;
            } else
                break;
        }
        return idx;
    }
}
