package com.willlee.leetcode.problems1301_1400;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(index[i], nums[i]);
        }
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = res.get(i);
        }
        return target;
    }
}
