package com.willlee.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
        if (arr.length == 0) {
            return ans;
        }
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;
        map.put(copy[0], index);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] != copy[i - 1]) {
                index++;
                map.put(copy[i], index);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

    public int[] arrayRankTransform1(int[] arr) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, j = 1;

        for (int i : arr) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        // 最大值和最小值的差值，是数组的长度
        int[] bucket = new int[max - min + 1];
        // arr数组中每个数字和min的差值，是数组下标，并且val设置为1
        for (int i : arr) {
            bucket[i - min] = 1;
        }
        // 但是每个数的index是连续的，所以改变val的值，第一个数赋值j=1，随后发现val=1的，便要+1，这样每个数的index便变成连续的了
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                bucket[i] = j++;
            }
        }

        int[] ans = new int[arr.length];

        int index = 0;
        for (int i : arr) {
            ans[index++] = bucket[i - min];
        }
        return ans;
    }
}
