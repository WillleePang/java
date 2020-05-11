package com.willlee.leetcode.problems301_400;

import java.util.Arrays;

public class Leetcode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;

        int k = primes.length;
        int[] index = new int[k];

        for (int i = 1; i < n; i++) {
            // 设定当前的最小值
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (min > dp[index[j]] * primes[j]) {
                    min = dp[index[j]] * primes[j];
                }
                dp[i] = min;
            }
            for (int j = 0; j < k; j++) {
                if (min == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Leetcode313 a = new Leetcode313();
        a.nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 });
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        Arrays.sort(primes);
        int[] dp = new int[n];
        dp[0] = 1;
        int[] point = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int ugly = minNum(dp, point, primes);
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[point[j]] == ugly) {
                    point[j] += 1;
                }
            }
            dp[i] = ugly;
        }
        return dp[n - 1];
    }

    int minNum(int[] dp, int[] point, int[] primes) {
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < point.length; i++) {
            min = Math.min(dp[point[i] * primes[i]], min);
        }
        return min;
    }
}
