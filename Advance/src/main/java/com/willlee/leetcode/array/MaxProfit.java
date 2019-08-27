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

    public int maxProfit11(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    public int maxProfit12(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    // leetcode122 只要有正数差值，就有利润，一直累加，就能获得最大利润
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return max;
    }

    public static int maxProfit21(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                int temp = dp[i - 1][0];
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], temp - prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    public static int maxProfit22(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
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

    public static int maxProfit31(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    // leetcode714
    public int maxProfit4(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public int maxProfit41(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }

    // leetcode309
    public int maxProfit5(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;// 代表dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    // leetcode188
    public int maxProfit6(int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            // 注意：可在同一天卖出和买入
            int[] dp = new int[prices.length + 1];
            dp[0] = 0;
            for (int i = 0; i < dp.length - 1; i++) {
                if (i == 1)
                    dp[1] = 0;
                for (int j = i + 1; j < dp.length - 1; j++) {
                    dp[j + 1] = dp[i + 1];
                    if (prices[i] >= prices[j])
                        continue;
                    if (dp[i + 1] + prices[j] - prices[i] > dp[j + 1])
                        dp[j + 1] = dp[i + 1] + prices[j] - prices[i];
                }
            }
            return dp[dp.length - 1];
        }
        int minprices = prices[0];
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = 0; i < n; i++) {
            if (prices[i] < minprices)
                minprices = prices[i];
            for (int m = 0; m <= k; m++) {
                if (m == 0) {
                    dp[i + 1][m][0] = 0;
                    dp[i + 1][m][1] = 0 - minprices;
                    continue;
                }
                if (i == 0) {
                    dp[i + 1][m][0] = 0;
                    dp[i + 1][m][1] = 0 - prices[0];
                    continue;
                }
                dp[i + 1][m][0] = Math.max(dp[i][m][0], dp[i][m - 1][1] + prices[i]);
                dp[i + 1][m][1] = Math.max(dp[i][m][1], dp[i][m][0] - prices[i]);
            }
        }
        return dp[n][k][0];
    }

    public static void main(String[] args) {
        maxProfit3(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 });
    }
}
