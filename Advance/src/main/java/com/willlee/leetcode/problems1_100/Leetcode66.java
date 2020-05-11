package com.willlee.leetcode.problems1_100;

import com.willlee.leetcode.utils.ArrayUtil;

//leetcode66
public class Leetcode66 {
    public static int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            return new int[] { 1 };
        }
        digits[digits.length - 1]++;// 在最后一位+1
        // 从末尾遍历除去最后一位的整个数组
        for (int i = digits.length - 2; i >= 0; i--) {
            // 如果当前位的后一位大于10，那么当前位+1，后一位取余
            digits[i] += digits[i + 1] / 10;
            digits[i + 1] %= 10;
        }
        // 如果第一位大于10，那么则要扩容一个数组，把第一位取余，新增的第一位变成1
        if (digits[0] / 10 == 1) {
            int[] a = new int[digits.length + 1];
            a[0] = 1;
            digits[0] %= 10;
            for (int i = 1; i < a.length; i++) {
                a[i] = digits[i - 1];
            }
            return a;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 9, 9, 9 };
        a = plusOne(a);
        ArrayUtil.print(a);
    }
}
