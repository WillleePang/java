package com.willlee.leetcode;

public class Leetcode1399 {
    public int countLargestGroup(int n) {
        int ans = 0, max = 1;
        int[] count = new int[n + 1];// 统计数位和有多少
        int[] sum = new int[n + 1]; // 计算1-n各个元素的数位和，例如数字i的数位和是sum[i / 10] + i %
                                    // 10
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i / 10] + i % 10;
            count[sum[i]]++;
            if (count[sum[i]] > max)
                max = count[sum[i]];
        }

        for (int num : count)
            ans += num == max ? 1 : 0;

        return ans;
    }
}
