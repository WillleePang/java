package com.willlee.leetcode.problems401_500;

//leetcode495
public class Leetcode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i] + duration > timeSeries[i + 1]) {
                res += timeSeries[i + 1] - timeSeries[i];
            } else {
                res += duration;
            }
        }
        return res + duration;
    }
}
