package com.willlee.leetcode.problems1001_1100;

import java.util.Stack;

public class Leetcode1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        Leetcode1047 a = new Leetcode1047();
        String removeDuplicates = a.removeDuplicates1(s);
        System.out.println(removeDuplicates);
    }

    public String removeDuplicates1(String S) {
        int i = 0;
        char[] res = S.toCharArray();
        for (int j = 0; j < res.length; j++, i++) {
            res[i] = res[j];
            if (i > 0 && res[i] == res[i - 1]) {
                i -= 2;
            }
        }
        return new String(res, 0, i);
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && S.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
