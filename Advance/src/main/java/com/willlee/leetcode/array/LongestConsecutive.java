package com.willlee.leetcode.array;

import java.util.HashSet;
import java.util.Set;

//leetcode128
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }

        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1))
                    current--;
                currentLongest += (num - current);
                current = num;
                while (numsSet.remove(current + 1))
                    current++;
                currentLongest += (current - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }
}
