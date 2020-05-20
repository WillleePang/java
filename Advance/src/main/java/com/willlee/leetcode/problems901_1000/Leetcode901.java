package com.willlee.leetcode.problems901_1000;

import java.util.Stack;

public class Leetcode901 {

    public static void main(String[] args) {
        StockSpanner stock = new StockSpanner();
        System.out.println(stock.next(11));
        System.out.println(stock.next(3));
        System.out.println(stock.next(9));
        System.out.println(stock.next(5));
        System.out.println(stock.next(6));
        System.out.println(stock.next(4));
        System.out.println(stock.next(7));
        System.out.println(stock.next(10));
    }
}

class StockSpanner {
    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack<>();
        weights = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
}