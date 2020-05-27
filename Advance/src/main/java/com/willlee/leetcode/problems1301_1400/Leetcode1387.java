package com.willlee.leetcode.problems1301_1400;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode1387 {
    public static void main(String[] args) {
        Leetcode1387 a = new Leetcode1387();
        a.getKth(12, 15, 2);
    }

    private Map<Integer, Integer> memo;

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
        memo = new HashMap<Integer, Integer>();
        for (int i = lo; i <= hi; i++) {
            heap.offer(new int[] { i, getWeight(i) });
            if (heap.size() > k)
                heap.poll();
        }
        return heap.peek()[0];
    }

    private int getWeight(int num) {
        if (num == 1)
            return 0;
        if (memo.containsKey(num))
            return memo.get(num);
        int count = (num & 1) == 0 ? getWeight(num >>> 1) : getWeight(3 * num + 1);
        count++;
        memo.put(num, count);
        return count;
    }
}
