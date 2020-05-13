package com.willlee.leetcode.problems201_300;

import java.util.LinkedList;

public class Leetcode224 {
    public static void main(String[] args) {
        Leetcode224 a = new Leetcode224();
        a.calculate1("(1-(2-(3+4)-5)+6)");
    }

    char[] chs;
    int len;
    int p = 0;

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        chs = s.toCharArray();
        len = chs.length;
        return help();
    }

    // 返回以p为开头的最长表达式的值,末尾如果多出右括号，则完成后p指向该右括号后面一位，否则指向表达式最后一位的下一位
    // 保证调用的时候，p不会指向右括号,也不会超出范围,也不会后面没有元素
    private int help() {
        int ans = 0;

        char sym = '+';
        int num = 0;
        while (p < len) {
            char c = chs[p];
            if (c == ' ') {// 空格
                p++;
                continue;
            } else if (c == ')') {// 右括号
                p++;
                break;
            } else if (c == '+' || c == '-') {// 符号
                if (sym == '+') {
                    ans += num;
                } else {
                    ans -= num;
                }
                sym = c;
                num = 0;
                p++;
            } else if (c == '(') {// 左括号
                p++;
                num = help();
            } else {// 数字
                num = num * 10 + c - '0';
                p++;
            }
        }
        if (sym == '+')
            ans += num;
        else
            ans -= num;
        return ans;
    }

    public int calculate1(String s) {
        LinkedList<Boolean> stack = new LinkedList<>();
        int result = 0, opr = 0; // result: 当前的结果值; opr: 当前的被加/被减数
        Character op = null; // 当前要执行的运算符
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (op == null) {
                    // 遇到第一个运算符时，将result置为opr（即第一个运算符左边的数字）
                    result = opr;
                } else {
                    // result = result +/- opr;
                    result = cal(op, result, opr);
                }
                // 根据栈顶元素决定是否反转运算符
                op = swap(stack.peek() == null ? false : stack.peek(), c);
                opr = 0;
            } else if (c == '(') {
                stack.push(op != null && op == '-');
            } else if (c == ')') {
                stack.pop();
            } else if (c != ' ') {
                opr = opr * 10 + c - '0';
            }
        }
        if (op == null) {
            // 算式中没有运算符时，opr就是最终结果
            return opr;
        } else {
            // 否则将result与opr（即算式中最右边的数字）执行一次运算
            return cal(op, result, opr);
        }
    }

    char swap(boolean swap, char c) {
        if (swap) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    private int cal(char op, int opr1, int opr2) {
        switch (op) {
        case '+':
            return opr1 + opr2;
        case '-':
            return opr1 - opr2;
        default:
            return 0;
        }
    }
}
