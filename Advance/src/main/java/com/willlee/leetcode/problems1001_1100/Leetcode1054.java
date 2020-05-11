package com.willlee.leetcode.problems1001_1100;

public class Leetcode1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // 为了保证可以实现相邻一定不相等，可以依次交错排列同一个数字
        // 首先统计每个数字的出现次数
        // 首先从奇数位开始放置出现次数最多的数字
        // 将其余数字放置在奇数位
        // 将剩余数字依次放置在偶数位
        int len = barcodes.length;
        int[] count = new int[10001];
        for (int i = 0; i < len; i++) {
            count[barcodes[i]]++;
        }
        // 得到出现次数最多的数字
        int maxCount = 0;
        int maxNum = 0;
        for (int i = 0; i < 10001; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxNum = i;
            }
        }
        // 先填充奇数位置
        int[] result = new int[len];
        int pos = 0;
        int idx = 0;
        while (pos < len) {
            if (count[maxNum] <= 0) {
                break;// 填充完毕
            } else {
                count[maxNum]--;
                result[pos] = maxNum;
                pos += 2;
            }
        }
        // 填充奇数位置
        while (pos < len) {
            if (count[idx] <= 0) {
                idx++;
                continue;
            } else {
                count[idx]--;
                result[pos] = idx;
                pos += 2;
            }
        }
        // 填充偶数位置
        pos = 1;
        while (pos < len) {
            if (count[idx] <= 0) {
                idx++;
                continue;
            } else {
                count[idx]--;
                result[pos] = idx;
                pos += 2;
            }
        }
        return result;
    }
}
