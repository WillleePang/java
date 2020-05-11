package com.willlee.leetcode.problems101_200;

import java.util.Stack;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String s : tokens) {
            switch (s) {
            case "+":
                numStack[index - 2] += numStack[--index];
                break;
            case "-":
                numStack[index - 2] -= numStack[--index];
                break;
            case "*":
                numStack[index - 2] *= numStack[--index];
                break;
            case "/":
                numStack[index - 2] /= numStack[--index];
                break;
            default:
                // numStack[index++] = Integer.valueOf(s);
                // valueOf改为parseInt，减少自动拆箱装箱操作
                numStack[index++] = Integer.parseInt(s);
                break;
            }
        }
        return numStack[0];
    }

    public static int evalRPN1(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
            case "+":
                op2 = numStack.pop();
                op1 = numStack.pop();
                numStack.push(op1 + op2);
                break;
            case "-":
                op2 = numStack.pop();
                op1 = numStack.pop();
                numStack.push(op1 - op2);
                break;
            case "*":
                op2 = numStack.pop();
                op1 = numStack.pop();
                numStack.push(op1 * op2);
                break;
            case "/":
                op2 = numStack.pop();
                op1 = numStack.pop();
                numStack.push(op1 / op2);
                break;
            default:
                numStack.push(Integer.valueOf(s));
                break;
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        Leetcode150 a = new Leetcode150();
        a.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" });
    }
}
