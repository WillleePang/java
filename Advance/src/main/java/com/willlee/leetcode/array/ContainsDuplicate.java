package com.willlee.leetcode.array;

import java.util.HashSet;
import java.util.Set;

//leetcode217
public class ContainsDuplicate {
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
