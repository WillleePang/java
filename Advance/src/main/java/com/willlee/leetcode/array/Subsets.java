package com.willlee.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//leetcode78
public class Subsets {
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        // 空集
        results.add(new LinkedList<>());
        for (int num : nums) {
            results.addAll(results.stream().map(subset -> {
                List<Integer> newSubset = new LinkedList<>(subset);
                newSubset.add(num);
                return newSubset;
            }).collect(Collectors.toList()));
        }
        return results;
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        backTracing(list, nums, 0);
        return res;
    }

    public void backTracing(List<Integer> list, int[] nums, int i) {
        res.add(list);
        for (int j = i; j < nums.length; ++j) {
            list.add(nums[j]);
            backTracing(new ArrayList<Integer>(list), nums, j + 1);
            list.remove(list.size() - 1); // remove(int index)
        }
        return;
    }
}
