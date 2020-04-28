package com.willlee.leetcode;

import java.util.PriorityQueue;

public class Leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        if (matrix.length == 0) {
            return -1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int a = matrix[i][j];
                queue.offer(a);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Leetcode378 a = new Leetcode378();
        int kthSmallest = a.kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8);
        System.out.println(kthSmallest);
    }
}
