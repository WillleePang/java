package com.willlee.leetcode.problems801_900;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode882 {
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        for (int[] edge : edges) {
            m.computeIfAbsent(edge[0], t -> new HashMap<>()).put(edge[1], edge[2]);
            m.computeIfAbsent(edge[1], t -> new HashMap<>()).put(edge[0], edge[2]);
        }
        // 大顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // {M，0} M表示还剩多少步数，0表示顶点
        pq.add(new int[] { M, 0 });
        // 表示节点是否访问过
        Map<Integer, Integer> seen = new HashMap<>();
        while (!pq.isEmpty()) {
            // 取出步数最大的顶点
            int[] top = pq.poll();
            // step remain
            int step = top[0];
            // current node
            int node = top[1];
            // 找到还未被访问的节点
            if (!seen.containsKey(node)) {
                // 标记节点已经被访问
                seen.put(node, step);
                // 找到与其相连的节点
                if (m.containsKey(node)) {
                    for (int next : m.get(node).keySet()) {
                        // 走过的步数是两点之间的节点数量nodeNums加上next节点，即nodeNums+1
                        int nodeNums = m.get(node).get(next);
                        int left = step - (nodeNums + 1);
                        if (left >= 0 && m.containsKey(next)) {
                            pq.add(new int[] { left, next });
                        }
                    }
                }
            }
        }
        int res = seen.size();
        for (int[] edge : edges) {
            int a = seen.getOrDefault(edge[0], 0);
            int b = seen.getOrDefault(edge[1], 0);
            res += Math.min(a + b, edge[2]);
        }
        return res;
    }
}