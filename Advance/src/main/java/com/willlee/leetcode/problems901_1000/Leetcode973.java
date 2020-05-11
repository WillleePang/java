package com.willlee.leetcode.problems901_1000;

import java.util.PriorityQueue;

public class Leetcode973 {
    public int[][] kClosest(int[][] points, int K) {
        if (null == points || points.length == 0) {
            return null;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (int[] a, int[] b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
