package com.willlee.leetcode.array;

public class MaxProfit {
    // leetcode121
    public int maxProfit1(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = prices[i] - min > max ? prices[i] - min : max;
            min = min > prices[i] ? prices[i] : min;
        }
        return max;
    }

    // leetcode122 只要有正数差值，就有利润，一直累加，就能获得最大利润
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        } else {
            int max = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                max += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
            }
            return max;
        }
    }

    // leetcode123
    public static int maxProfit3(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] leftMaxProfit = new int[prices.length];// 前i天中最大的
        int minPrice = prices[0];// 买入最低价格
        for (int i = 1; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            leftMaxProfit[i] = Math.max(prices[i] - minPrice, leftMaxProfit[i - 1]);
        }

        int[] rightMaxProfit = new int[prices.length]; // 后i天中最大的
        int maxPrice = prices[prices.length - 1];// 卖出最高价格
        for (int i = prices.length - 2; i > 0; i--) {
            if (maxPrice < prices[i]) {
                maxPrice = prices[i];
            }
            rightMaxProfit[i] = Math.max(maxPrice - prices[i], rightMaxProfit[i + 1]);
        }
        // 前i天最大值和i天后最大值之和最大值
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, leftMaxProfit[i] + rightMaxProfit[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        maxProfit3(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 });
    }
}
