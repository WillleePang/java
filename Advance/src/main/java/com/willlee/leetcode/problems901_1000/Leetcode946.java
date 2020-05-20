package com.willlee.leetcode.problems901_1000;

import java.util.Stack;

public class Leetcode946 {
    public static void main(String[] args) {
        Leetcode946 a = new Leetcode946();
        a.validateStackSequences1(new int[] { 2, 1, 3, 0 }, new int[] { 1, 0, 3, 2 });
    }

    // 栈的特点 filo 模拟进栈出栈的过程
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int size = 0;
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            pushed[size] = pushed[i];
            size++;
            while (size > 0 && pushed[size - 1] == popped[j]) {
                size--;
                j++;
            }
        }
        return size == 0;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int a : popped) {
            if (stack.isEmpty()) {
                while (pushed[index] != a) {
                    stack.push(pushed[index++]);
                }
                index++;
            } else {
                if (stack.peek() == a) {
                    stack.pop();
                } else {
                    boolean isExist = false;
                    while (index < pushed.length) {
                        if (pushed[index] != a) {
                            stack.push(pushed[index++]);
                        } else {
                            index++;
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist)
                        return false;
                }
            }
        }
        return true;
    }
}
