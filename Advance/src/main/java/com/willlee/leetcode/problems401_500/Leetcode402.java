package com.willlee.leetcode.problems401_500;

import java.util.LinkedList;

public class Leetcode402 {
    public static void main(String[] args) {
        Leetcode402 a = new Leetcode402();
        a.removeKdigits1("12345264", 4);
    }

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char digit : num.toCharArray()) {
            // 筛选出左边比当前digit大的数字，并且次数k减一
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        // 如果k还有剩余，那么继续删除元素
        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }
        // 拼接最终字符串，并且去除最前面数字为0的字符
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        if (ret.length() == 0) {
            return "0";
        }
        return ret.toString();
    }

    public String removeKdigits1(String num, int k) {
        char[] chars = num.toCharArray();
        int len = chars.length;
        if (k == len) {
            return "0";
        }
        int countDelete = 0, pos = 0;
        for (int i = 1; i < len; i++) {
            char c = chars[i];
            // 筛选出左边比当前digit大的数字，并且次数k减一
            while (countDelete < k && pos >= 0 && chars[pos] > c) {

                pos--;
                countDelete++;
            }
            // 将当前的字符放到指定的位置
            chars[++pos] = c;
        }
        int start = 0, end = len - k;
        while (start < len && chars[start] == '0') {
            start++;
        }
        if (start >= end) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(chars[i]);
        }
        return result.toString();
    }
}
