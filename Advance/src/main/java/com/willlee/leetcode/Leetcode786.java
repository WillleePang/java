package com.willlee.leetcode;

import java.util.PriorityQueue;

public class Leetcode786 {

    public int[] kthSmallestPrimeFraction2(int[] A, int K) {
        // 因为分数是在(0,1)范围内，所以在此范围使用二分查找
        double lo = 0, hi = 1, mid;
        int p = 0, q = 1;
        int i, j;
        int count;
        // 因为是在小数内使用二分查找，无法像在整数范围内那样通过 mid+1和边界判断来终止循环
        // 所以此处根据count来结束循环
        while (true) {
            mid = (lo + hi) / 2;
            count = 0;
            p = 0;
            for (i = 0; i < A.length; i++) {
                j = 0;
                while (j < A.length - 1 - i && mid >= (double) A[i] / A[A.length - 1 - j]) {
                    j++;
                }
                count += j;
                // 重点：p/q是比 mid小的数中的最大值(所有行)
                if (j > 0 && ((double) p / q) < ((double) A[i] / A[A.length - j])) {
                    p = A[i];
                    q = A[A.length - j];
                }
            }
            if (count > K)
                hi = mid;
            else if (count < K)
                lo = mid;
            else
                return new int[] { p, q };
        }
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);

        for (int i = 1; i < A.length; ++i)
            pq.add(new int[] { 0, i });

        while (--K > 0) {
            int[] frac = pq.poll();
            if (frac[0]++ < frac[1])
                pq.offer(frac);
        }

        int[] ans = pq.poll();
        return new int[] { A[ans[0]], A[ans[1]] };
    }

    public int[] kthSmallestPrimeFraction1(int[] primes, int K) {
        double lo = 0, hi = 1;
        int[] ans = new int[] { 0, 1 };

        while (hi - lo > 1e-9) {
            double mi = lo + (hi - lo) / 2.0;
            int[] res = under(mi, primes);
            if (res[0] < K) {
                lo = mi;
            } else {
                ans[0] = res[1];
                ans[1] = res[2];
                hi = mi;
            }
        }
        return ans;
    }

    public int[] under(double x, int[] primes) {
        // Returns {count, numerator, denominator}
        int numer = 0, denom = 1, count = 0, i = -1;
        for (int j = 1; j < primes.length; ++j) {
            // For each j, find the largest i so that primes[i] / primes[j] < x
            // It has to be at least as big as the previous i, so reuse it ("two
            // pointer")
            while (primes[i + 1] < primes[j] * x)
                ++i;

            // There are i+1 fractions: (primes[0], primes[j]),
            // (primes[1], primes[j]), ..., (primes[i], primes[j])
            count += i + 1;
            if (i >= 0 && numer * primes[j] < denom * primes[i]) {
                numer = primes[i];
                denom = primes[j];
            }
        }
        return new int[] { count, numer, denom };
    }

    public static void main(String[] args) {

        double mi = 0 + (1 - 0) / 2.0;
        System.out.println(mi);
        Leetcode786 a = new Leetcode786();
        int[] kthSmallestPrimeFraction = a.kthSmallestPrimeFraction(new int[] { 1, 2, 3, 5 }, 3);
        System.out.println(kthSmallestPrimeFraction[0] + " " + kthSmallestPrimeFraction[1]);
    }
}
