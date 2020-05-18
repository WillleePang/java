package com.willlee.leetcode.problems1101_1200;

import java.util.Stack;

public class Leetcode1190 {
    public static void main(String[] args) {
        Leetcode1190 a = new Leetcode1190();
        String reverseParentheses = a.reverseParentheses1("(ed(et(oc))el)");
        System.out.println(reverseParentheses);
    }

    public String reverseParentheses1(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] pair = new int[n];

        // 先去找匹配括号
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        // i是当前位置 | d是方向,1就是向右穿
        for (int i = 0, d = 1; i < n; i += d) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                // 如果碰到括号，那么去他对应的括号，并且将方向置反
                i = pair[i];
                d = -d;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            }
            if (arr[i] == ')') {
                reverse(arr, stack.pop() + 1, i - 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ')' && arr[i] != '(') {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    private void reverse(char[] arr, int left, int right) {
        while (right > left) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            right--;
            left++;
        }
    }
}
