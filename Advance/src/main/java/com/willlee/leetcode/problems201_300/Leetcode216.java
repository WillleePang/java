package com.willlee.leetcode.problems201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode216
public class Leetcode216 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        traceBack(k, n, 0, 1, new LinkedList<>());
        return ans;
    }

    public void traceBack(int k, int n, int sum, int begin, LinkedList<Integer> list) {
        if (k == 0) {
            if (n == sum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = begin; i < 10; i++) {
            list.add(i);
            traceBack(k - 1, n, sum + i, i + 1, list);
            list.removeLast();
        }
    }
}
