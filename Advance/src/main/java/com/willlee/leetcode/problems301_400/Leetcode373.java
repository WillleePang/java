package com.willlee.leetcode.problems301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0)
            return result;
        int[][] arr = new int[n1 * n2][2];
        int idx = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                arr[idx][0] = nums1[i];
                arr[idx][1] = nums2[j];
                idx++;
            }
        }

        Arrays.sort(arr, (o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));

        for (int i = 0; i < Math.min(k, arr.length); i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(arr[i][0]);
            tmp.add(arr[i][1]);
            result.add(tmp);
        }
        return result;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));
        List<List<Integer>> result = new ArrayList<>();

        if (n1 == 0 || n2 == 0 || k == 0)
            return result;
        for (int i = 0; i < n1; i++)
            pq.offer(new int[] { i, 0 });

        while (pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2)
                pq.offer(new int[] { pair[0], pair[1] + 1 });
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }

        return result;
    }
}
