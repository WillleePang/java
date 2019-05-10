package com.willlee.algo.stack;

public class ArrayStack {
    private String[] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        this.n = n;
        this.count = 0;
        this.items = new String[n];
    }

    public boolean push(String item) {
        if (count == n) {
            return false;
        } else {
            items[count] = item;
            count++;
            return true;
        }
    }

    public String pop() {
        if (count == 0) {
            return null;
        } else {
            String tmp = items[count - 1];
            --count;
            return tmp;
        }
    }
}
