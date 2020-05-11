package com.willlee.leetcode.problems201_300;

import java.util.HashSet;
import java.util.Set;

//leetcode217
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x))
                return true;
            else
                set.add(x);
        }
        return false;
    }

}
