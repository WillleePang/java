package com.willlee.leetcode.problems1201_1300;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode1249 {
    public static void main(String[] args) {
        Leetcode1249 a = new Leetcode1249();
        a.minRemoveToMakeValid2("L(e)))et((co)d(e)");
    }

    public String minRemoveToMakeValid2(String s) {
        char[] cs = s.toCharArray();
        int size = cs.length;
        int[] stack = new int[size];
        int sidx = 0;

        for (int i = 0; i < size; i++) {
            char c = cs[i];
            if (c == '(') {
                stack[sidx++] = i;
            } else if (c == ')') {
                if (sidx > 0)
                    sidx--;
                else
                    cs[i] = ' ';
            }
        }

        while (sidx > 0) {
            cs[stack[--sidx]] = ' ';
        }

        int widx = 0;
        for (int i = 0; i < size; i++) {
            if (cs[i] != ' ')
                cs[widx++] = cs[i];
        }
        return new String(cs, 0, widx);
    }

    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }

    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            }
            if (c == close) {
                if (balance == 0)
                    continue;
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }
}
