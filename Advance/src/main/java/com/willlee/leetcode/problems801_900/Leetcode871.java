package com.willlee.leetcode.problems801_900;

import java.util.PriorityQueue;

public class Leetcode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            // 多了一加油站i，所有i-1之前的数据需要重新计算
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + (long) stations[i][1]);
        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target)
                return i;
        return -1;
    }

    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        // dp[i][j]表示经过i站加油j次能够到达的最远距离
        int[][] dp = new int[n + 1][n + 1];

        if (startFuel >= target)
            return 0;
        for (int i = 0; i < n; i++)
            dp[i][0] = startFuel;

        for (int i = 1; i <= n; i++) {
            int currStationPos = stations[i - 1][0];
            int currStationGas = stations[i - 1][1];
            for (int j = 1; j <= i; j++) {
                // 因为dp[i][j]表示经过前i站，一共加油j次。要么第i站加油，1~i-1站加j-1次；要么第i站不加油，前面1~i-1加j次
                // 前i-1站加j次，本站不加油
                if (dp[i - 1][j] >= currStationPos) {
                    dp[i][j] = dp[i - 1][j];
                }
                // max(前i-1站加j次，本站不加油, 前i-1站加j-1次，本站加油)
                if (dp[i - 1][j - 1] >= currStationPos) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + currStationGas);
                }
            }
        }

        // 此时走完了n站，看看最少加油几次能达到target
        for (int refuelTimes = 0; refuelTimes <= n; refuelTimes++)
            if (dp[n][refuelTimes] >= target)
                return refuelTimes;
        return -1;
    }

    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 当前车中的油量
        int current = startFuel;
        // 加油的次数
        int times = 0;
        for (int i = 0; i < stations.length; i++) {
            if (current < stations[i][0]) {// 车中的油不能到加油站
                // 取堆顶的油加入到车中
                while (!pq.isEmpty() && current < stations[i][0]) {
                    current += pq.poll();
                    times++;
                }
                // 不够，到达不了
                if (current < stations[i][0]) {
                    return -1;
                }
            }
            pq.offer(stations[i][1]);
        }
        while (!pq.isEmpty() && current < target) {
            current += pq.poll();
            times++;
        }
        if (current < target) {
            return -1;
        }
        return times;
    }

}
