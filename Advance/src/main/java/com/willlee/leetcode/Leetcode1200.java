package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int min = Math.abs(arr[1] - arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == min) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(arr[i - 1]);
                list1.add(arr[i]);
                list.add(list1);
            } else if (Math.abs(arr[i] - arr[i - 1]) < min) {
                list.clear();
                List<Integer> list1 = new ArrayList<>();
                list1.add(arr[i - 1]);
                list1.add(arr[i]);
                list.add(list1);
                min = arr[i] - arr[i - 1];
            }

        }
        return list;
    }
}
