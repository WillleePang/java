package com.willlee.leetcode.problems1101_1200;

public class Leetcode1130 {
    // 这题不要把它当成树的题目就好解了，对于每一个最小值我们需要去除它只能是以和当前数据中左右最近的数据乘积作为代价来消除。
    // 每一次循环找最小值去除，共需要循环arr.length- 1次
    public int mctFromLeafValues1(int[] arr) {
        int result = 0;
        //位置是否被访问过了
        boolean[] taged = new boolean[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            //首先找到数组中最小的值
            for (int j = 0; j < arr.length; j++) {
                if (!taged[j] && arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            //找到它左边未被访问过的数值
            int l;
            for (l = index - 1; l >= 0 && taged[l]; l--)
                ;
            int leftVal = l < 0 ? Integer.MAX_VALUE : arr[l];
            //找到它右边未被访问过的数值
            int r;
            for (r = index + 1; r < arr.length && taged[r]; r++)
                ;
            int rightVal = r >= arr.length ? Integer.MAX_VALUE : arr[r];
            //找到最小乘积
            result += Math.min(leftVal, rightVal) * arr[index];
            taged[index] = true;
        }
        return result;
    }

    public int mctFromLeafValues(int[] arr) {
        int len;
        if (arr == null || (len = arr.length) == 0)
            return 0;
        int[][][] dp = new int[len][len][2];
        // 初始状态.
        for (int i = 0; i < len; ++i) {
            dp[i][i][0] = arr[i];
        }
        // 固定一端式，典型的O(n3)时间复杂度的算法
        for (int i = 1; i < len; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                dp[j][i][1] = Integer.MAX_VALUE;
                int tmp;
                for (int k = j; k < i; ++k) {
                    if ((tmp = dp[j][k][1] + dp[k + 1][i][1] + dp[j][k][0] * dp[k + 1][i][0]) < dp[j][i][1]) {
                        dp[j][i][1] = tmp;
                        dp[j][i][0] = Math.max(dp[j][k][0], dp[k + 1][i][0]);
                    }
                }
            }
        }
        return dp[0][len - 1][1];
    }

    public static void main(String[] args) {
        Leetcode1130 a = new Leetcode1130();
        a.mctFromLeafValues(new int[] { 6, 2, 3 });
    }
}
