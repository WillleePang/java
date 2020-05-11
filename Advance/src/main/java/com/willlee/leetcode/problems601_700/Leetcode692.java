package com.willlee.leetcode.problems601_700;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1) : count.get(w1) - count.get(w2));
        for (String key : count.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (queue.size() > 0) {
            list.add(queue.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
