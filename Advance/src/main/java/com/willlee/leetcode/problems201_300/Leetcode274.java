package com.willlee.leetcode.problems201_300;

import java.util.Arrays;

public class Leetcode274 {
    public static void main(String[] args) {
        Leetcode274 a = new Leetcode274();
        a.hIndex1(new int[] { 3, 0, 6, 1, 5 });
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations); // 默认的是从小到大排序，所以后边要倒着遍历
        int n = 1; // 论文序号
        // 倒着遍历就是从大到小遍历了
        for (int i = citations.length - 1; i >= 0; i--) {
            // 论文序号大于该论文的被引次数
            if (n > citations[i]) {
                break;
            }
            n++;
        }
        // 所得序号减一即为 H 指数。
        return n - 1;
    }

    public int hIndex1(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        // 计数
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        // 依次判断被引次数大于等于 N 的论文数是否大于等于 N
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
