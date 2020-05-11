package com.willlee.leetcode.problems1001_1100;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            if (x != y) {
                queue.offer(y - x);
            }
        }

        if (queue.size() == 2) {
            return queue.poll() - queue.poll();
        } else if (queue.size() == 1) {
            return queue.poll();
        } else {
            return 0;
        }
    }

    public int lastStoneWeight1(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        int index = stones.length - 1;
        Arrays.sort(stones);
        while (stones[index - 1] != 0) {
            int x = stones[index - 1];
            int y = stones[index];
            if (x == y) {
                stones[index] = stones[index - 1] = 0;
            } else {
                stones[index - 1] = 0;
                stones[index] = y - x;
            }
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }

    public int lastStoneWeight2(int[] stones) {
        int index = stones.length - 1;
        for (int i = 0; i < stones.length - 1; i++) {
            Arrays.sort(stones);
            stones[index] -= stones[index - 1];
            stones[index - 1] = 0;
        }
        return stones[stones.length - 1];
    }

    public static void main(String[] args) {
        Leetcode1046 a = new Leetcode1046();
        a.lastStoneWeight(new int[] { 2, 2 });

    }
}
