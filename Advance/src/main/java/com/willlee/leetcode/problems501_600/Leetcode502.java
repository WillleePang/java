package com.willlee.leetcode.problems501_600;

import java.util.PriorityQueue;

public class Leetcode502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        boolean speedUp = true;
        // 如果初始资本大于所有的项目所需资本，那么直接选取k个利润最大的项目
        for (int c : Capital) {
            if (W < c)
                speedUp = false;
        }
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p : Profits) {
                heap.add(p);
                if (heap.size() > k)
                    heap.poll();
            }
            for (int h : heap)
                W += h;
            return W;
        }

        int idx;
        int n = Profits.length;
        // 执行选取项目的次数
        for (int i = 0; i < Math.min(k, n); ++i) {
            idx = -1;
            // 当前项目中，利润最大
            for (int j = 0; j < n; j++) {
                if (W >= Capital[j]) {
                    if (idx == -1)
                        idx = j;
                    else if (Profits[idx] < Profits[j]) {
                        idx = j;
                    }
                }
            }
            if (idx == -1)
                break;
            // 利润总和，并且将用过的项目设置为不可用
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;
        }
        return W;
    }
}
