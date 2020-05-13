package com.willlee.leetcode.problems301_400;

import java.util.Stack;

public class Leetcode394 {
    public static void main(String[] args) {
        Leetcode394 a = new Leetcode394();
        a.decodeString1("3[a2[c]]");
    }

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);
            } else if (c == '[') {
                if (num > 0)
                    numStack.push(num);
                strStack.push(sb.toString());
                sb = new StringBuilder();
                num = 0;
            } else {
                StringBuilder preSB = new StringBuilder().append(strStack.pop());
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    preSB.append(sb);
                }
                sb = preSB;
            }
        }
        return sb.toString();
    }

    public String decodeString1(String s) {
        int len = s.length();
        if (len == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int l = 0, r = 0, k = 0, count = 0;
        while (r < len) {
            if (count == 0 && '0' <= s.charAt(r) && s.charAt(r) <= '9') {
                // 添加第一个字符串
                sb.append(s.substring(l, r));
                // 计算字符串数字
                while ('0' <= s.charAt(r) && s.charAt(r) <= '9') {
                    k *= 10;
                    k = k + (s.charAt(r) - '0');
                    r++;
                }
                l = r;
            } else if (count == 0 && s.charAt(r) == '[') {
                l = r;
                count++;
                String s1 = "";
                // 对需要进行递归的字符串递归
                while (count != 0) {
                    r++;
                    if (s.charAt(r) == '[')
                        count++;
                    if (s.charAt(r) == ']')
                        count--;
                    if (count == 0) {
                        s1 = decodeString(s.substring(l + 1, r));
                        break;
                    }
                }
                for (int i = 0; i < k; i++) {
                    sb.append(s1);
                }
                k = 0;
                r++;
                l = r;
            } else {
                r++;
            }
        }
        sb.append(s.substring(l, len));
        return sb.toString();
    }
}
