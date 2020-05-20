package com.willlee.leetcode.problems1001_1100;

import java.util.Stack;

public class Leetcode1003 {
    public boolean isValid(String S) {
        if (S.length() % 3 != 0)
            return false;
        char[] cha = S.toCharArray();
        int index = 0;
        char[] result = new char[S.length()];
        for (char ch : cha) {
            if (ch != 'c') {
                result[index++] = ch;
            } else {
                if (index < 2 || result[--index] != 'b' || result[--index] != 'a')
                    return false;
            }
        }
        return index == 0;
    }

    public boolean isValid2(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(S.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String S) {
        while (S.contains("abc")) {
            S = S.replaceAll("abc", "");
        }
        return S.equals("");
    }
}
