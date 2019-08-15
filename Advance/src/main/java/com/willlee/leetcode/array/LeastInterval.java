package com.willlee.leetcode.array;

import java.util.Arrays;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (len < 1 || n < 0) {
            return 0;
        }
        int[] nums = new int[26];
        int i = 0;
        // 得到每个字符的数量后再排序
        while (i < len) {
            nums[tasks[i++] - 65]++;
        }
        Arrays.sort(nums);
        // res的最小值
        int res = (nums[25] - 1) * (n + 1);
        i = 25;
        while (i >= 0 && nums[i] == nums[25]) {
            // 若最多数量的字符有多个 则res相应地+1
            res++;
            i--;
        }
        // 得到的结果为res与数组长度len之间最大值
        return res > len ? res : len;
    }
}