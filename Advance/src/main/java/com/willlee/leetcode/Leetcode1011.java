package com.willlee.leetcode;

public class Leetcode1011 {
    public int shipWithinDays(int[] weights, int D) {
        // 二分查找，根据题意，结果一定落在【max(weights),
        // sum(weights）】这个区间之间，因为左端点对应每天一条船，右端点对应只有一条超级大船。
        // 然后利用二分法，每一次循环模拟运货的过程，然后根据需要的天数与 输入 D 的关系来调整区间左右端点。
        int low = 0;
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        while (low < high) {
            int mid = (low + high) / 2;
            int temp = 0;
            int day = 1;
            for (int weight : weights) {
                temp += weight;
                if (temp > mid) {
                    // 把weight重量的货物留到第二天再运
                    temp = weight;
                    day++;
                }
            }
            if (day > D) {// 需要时间长于规定时间，则需要加大容量；
                low = mid + 1;
            } else {// 反之，则需要减小容量
                high = mid;
            }
        }
        return low;
    }
}
