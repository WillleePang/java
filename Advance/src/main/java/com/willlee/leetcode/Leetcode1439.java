package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode1439 {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> answer = new ArrayList<>(k);
        // 获取当前的最小值
        for (int i = 0; i < n; i++) {
            answer.add(mat[0][i]);
        }

        for (int i = 1; i < m; i++) {
            // 当前一行的所有数值，list中的数相加，取前k个最小值，其他的删除
            List<Integer> newSum = new ArrayList<>();
            for (int oldSum : answer) {
                for (int num : mat[i]) {
                    newSum.add(oldSum + num);
                }
            }
            // 排序
            Collections.sort(newSum);
            answer.clear();
            // 获取最小的个数
            int len = Math.min(k, newSum.size());
            // 把新的前k个最小值，拷贝到list中去
            for (int j = 0; j < len; j++) {
                answer.add(newSum.get(j));
            }
        }
        return answer.get(k - 1);
    }

    public int kthSmallest1(int[][] mat, int k) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++)
            sum += mat[i][0];

        PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> o1.total - o2.total);

        Set<String> visit = new HashSet<>();
        Item first = new Item(new int[mat.length], sum);
        visit.add(Arrays.toString(first.pick));
        pq.offer(first);

        while (k > 1) {
            Item item = pq.poll();

            for (int i = 0; i < mat.length; i++) {
                item.pick[i]++;

                if (item.pick[i] < mat[i].length && !visit.contains(Arrays.toString(item.pick))) {
                    visit.add(Arrays.toString(item.pick));
                    int[] pick = Arrays.copyOf(item.pick, item.pick.length);

                    int total = item.total - mat[i][item.pick[i] - 1] + mat[i][item.pick[i]];
                    pq.add(new Item(pick, total));
                }

                item.pick[i]--;
            }
            k--;
        }

        return pq.peek().total;
    }

    private class Item {
        private int[] pick;
        private int total;

        public Item(int[] pick, int total) {
            this.pick = pick;
            this.total = total;
        }
    }

    public static void main(String[] args) {
        Leetcode1439 a = new Leetcode1439();
        int kthSmallest = a.kthSmallest1(new int[][] { { 1, 10, 10 }, { 1, 4, 5 }, { 2, 3, 6 } }, 7);
        System.out.println(kthSmallest);
    }
}
