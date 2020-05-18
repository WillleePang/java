package com.willlee.leetcode.problems1301_1400;

public class Leetcode1381 {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}

class CustomStack {
    private int[] stack;
    private int[] increment;
    private int size = 0;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        increment = new int[maxSize + 1];
    }

    public void push(int x) {
        if (size == stack.length) {
            return;
        }
        stack[size++] = x;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        int val = stack[size - 1];
        if (increment[size] != 0) {
            val += increment[size];

            increment[size - 1] += increment[size];
            increment[size] = 0;
        }
        size--;
        return val;
    }

    public void increment(int k, int val) {
        int t = k > size ? size : k;
        increment[t] += val;
    }
}

class CustomStack1 {
    private int[] aux;
    private int n;

    public CustomStack1(int maxSize) {
        aux = new int[maxSize];
        n = 0;
    }

    public void push(int x) {
        if (n == aux.length)
            return;
        aux[n++] = x;
    }

    public int pop() {
        if (n == 0)
            return -1;
        return aux[--n];
    }

    public void increment(int k, int val) {
        int boundary = Math.min(k, n);
        for (int i = 0; i < boundary; i++)
            aux[i] += val;
    }
}