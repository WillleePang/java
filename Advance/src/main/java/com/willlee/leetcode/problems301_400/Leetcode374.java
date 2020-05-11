package com.willlee.leetcode.problems301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode374 {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] tmp = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (tmp[i] == null) {
                tmp[i] = new ArrayList<>();
            }
            tmp[i].add(key);
        }
        for (int i = tmp.length - 1; i >= 0 && ans.size() < k; i--) {
            if (tmp[i] == null)
                continue;
            ans.addAll(tmp[i]);
        }
        int[] a = new int[k];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}
