package com.willlee.leetcode.problems801_900;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode857 {
    public double mincostToHireWorkers1(int[] quality, int[] wage, int K) {
        int len = wage.length;
        double[][] nums = new double[len][2];
        for (int i = 0; i < len; i++) {
            nums[i][0] = wage[i] * 1.0 / quality[i];
            nums[i][1] = quality[i];
        }
        // 根据单位成本从低到高排序
        Comparator<double[]> comp = new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                return a[0] > b[0] ? 1 : (a[0] == b[0] ? 0 : -1);
            }
        };
        Arrays.sort(nums, comp);
        double sum = 0;
        double res = 0;
        // 大顶堆
        Comparator<Double> comp2 = new Comparator<Double>() {
            public int compare(Double a, Double b) {
                return a < b ? 1 : (a == b ? 0 : -1);
            }
        };
        PriorityQueue<Double> queue = new PriorityQueue<>(comp2);
        // 先计算前K个值
        for (int i = 0; i < K; i++) {
            sum += nums[i][1];
            queue.offer(nums[i][1]);
        }
        // 从K+1开始遍历，更新堆，求最小值
        res = nums[K - 1][0] * sum;
        for (int i = K; i < len; i++) {
            if (nums[i][1] < queue.peek()) {
                sum = sum - queue.poll() + nums[i][1];
                queue.offer(nums[i][1]);
                res = Math.min(sum * nums[i][0], res);
            }
        }
        return res;
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<Integer>();
        for (Worker worker : workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > K)
                sumq += pool.poll();
            if (pool.size() == K)
                ans = Math.min(ans, sumq * worker.ratio());
        }

        return ans;
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;

    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }
}