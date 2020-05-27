package com.willlee.leetcode.problems1301_1400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode1353 {
    public static void main(String[] args) {
        Leetcode1353 a = new Leetcode1353();
        a.maxEvents1(new int[][] { { 1, 4 }, { 4, 4 }, { 2, 2 }, { 3, 4 }, { 1, 1 } });
    }

    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int i = 0, res = 0, n = events.length;
        // 循环访问每一天
        for (int d = 1; d <= 100000; ++d) {
            // 把今天开始时间的数组找出来，然后把结束时间放入最小堆
            while (i < n && events[i][0] == d) {
                queue.offer(events[i++][1]);
            }
            while (queue.size() > 0 && queue.peek() < d) {
                queue.poll();
            }
            // 找到最早结束的会议
            if (queue.size() > 0) {
                queue.poll();
                res++;
            }
        }
        return res;
    }

    public int maxEvents1(int[][] events) {
        if (events.length > 10000) {
            return events.length;
        }
        // 结束时间升序排列，结束时间相同的话，开始时间按照升序排列
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Set<Integer> res = new HashSet<>();
        // 获取最早结束的会议
        for (int[] event : events) {
            for (int i = event[0]; i <= event[1]; i++) {
                // 如果add返回成功，那么意味着i天的会议可以参加，并且break，直接寻找下一个会议
                // 如果后一个会议覆盖了前一个会议的部分时间，那么add一直会返回false，则继续找到不重复的天数，然后add返回true
                if (res.add(i)) {
                    break;
                }
            }
        }
        return res.size();
    }
}
