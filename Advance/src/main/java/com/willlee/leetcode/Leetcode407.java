package com.willlee.leetcode;

import java.util.PriorityQueue;

public class Leetcode407 {
    public int trapRainWater(int[][] heights) {
        // 接雨水I中，我们维护了左右两个最高的墙，那么在这里，就是维护周围一个圈，用堆来维护周围这一圈中的最小元素。
        // 为什么是维护最小的元素不是最大的元素呢，因为木桶原理呀。这个最小的元素从堆里弹出来，和它四个方向的元素去比较大小，
        // 看能不能往里灌水，怎么灌水呢，如果用方向就比较复杂了，我们可以用visited数组来表示哪些遍历过，哪些没遍历过。
        // 如果当前弹出来的高度比它周围的大，那就是能灌水，把下一个柱子放进去的时候，放的高度要取两者较大的，也就是灌水后的高度，
        // 而不是它原来矮的高度了，如果不能灌水，继续走。
        if (heights == null || heights.length == 0)
            return 0;
        int n = heights.length;
        int m = heights[0].length;
        // 用一个vis数组来标记这个位置有没有被访问到
        boolean[][] vis = new boolean[n][m];
        // 有限队列中存放三元组[x,y,h]坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        // 先把最外面的一圈放进去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[] { i, j, heights[i][j] });
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        int[] dirs = { -1, 0, 1, 0, -1 };
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // 看四个方向
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // 如果位置合法且没访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (poll[2] > heights[nx][ny]) {
                        res += poll[2] - heights[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    pq.offer(new int[] { nx, ny, Math.max(heights[nx][ny], poll[2]) });
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }
}
