package com.willlee.leetcode.problems901_1000;

import java.util.Stack;

public class Leetcode921 {
    public static void main(String[] args) {
        Leetcode921 a = new Leetcode921();
        a.minAddToMakeValid2("()))((");
    }

    public int minAddToMakeValid(String S) {
        while (S.contains("()")) {
            S = S.replace("()", "");
        }
        return S.length();
    }

    public int minAddToMakeValid1(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public int minAddToMakeValid2(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}
