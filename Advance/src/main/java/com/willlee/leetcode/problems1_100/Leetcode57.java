package com.willlee.leetcode.problems1_100;

import java.util.ArrayList;
import java.util.List;

//leetcode57
public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length < 1) {
            return new int[][] { newInterval };
        }

        List<int[]> list = new ArrayList<>();

        for (int[] item : intervals) {
            if (item[1] < newInterval[0]) {
                list.add(item);
            }
        }

        for (int[] item : intervals) {
            if (item[0] <= newInterval[0] && newInterval[0] <= item[1]) {
                newInterval[0] = Math.min(item[0], newInterval[0]);
                newInterval[1] = Math.max(item[1], newInterval[1]);
            }
            if (item[0] <= newInterval[1] && newInterval[1] <= item[1]) {
                newInterval[0] = Math.min(item[0], newInterval[0]);
                newInterval[1] = Math.max(item[1], newInterval[1]);
            }
        }

        list.add(newInterval);

        for (int[] item : intervals) {
            if (item[0] > newInterval[1]) {
                list.add(item);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}
