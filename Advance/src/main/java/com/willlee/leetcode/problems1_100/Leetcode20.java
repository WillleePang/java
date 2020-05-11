package com.willlee.leetcode.problems1_100;

import java.util.Stack;

//leetcode20
public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(')
                    return false;
                if (c == '}' && top != '{')
                    return false;
                if (c == ']' && top != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        int len = s.length();
        char[] symbolArr = new char[len];
        int pos = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                symbolArr[pos++] = c;
            } else {
                if (pos == 0) {
                    return false;
                }
                char before = symbolArr[--pos];
                if ((c == ')' && before == '(') || (before == '{' && c == '}') || before == '[' && c == ']') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return pos == 0;
    }
}
