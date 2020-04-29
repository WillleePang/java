package com.willlee.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights)
            graph[flight[0]][flight[1]] = flight[2];

        Map<Integer, Integer> best = new HashMap<Integer, Integer>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] { 0, 0, src });

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            // 消费、转站次数、地点
            int cost = info[0], k = info[1], place = info[2];
            // 如果队列中存在长度超过k 过滤掉，或者剪枝
            if (k > K + 1 || cost > best.getOrDefault(k * 1000 + place, Integer.MAX_VALUE))
                continue;
            // 到达目的地
            if (place == dst)
                return cost;
            // 当前站与其他站的距离
            for (int i = 0; i < n; i++) {
             // 边存在，遍历每个以info为起点的边
                if (graph[place][i] > 0) {
                    int newcost = cost + graph[place][i];
                    if (newcost < best.getOrDefault((k + 1) * 1000 + i, Integer.MAX_VALUE)) {
                        queue.offer(new int[] { newcost, k + 1, i });
                        best.put((k + 1) * 1000 + i, newcost);
                    }
                }
            }
        }

        return -1;

    }

}
