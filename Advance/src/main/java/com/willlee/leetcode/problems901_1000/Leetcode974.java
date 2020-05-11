package com.willlee.leetcode.problems901_1000;

public class Leetcode974 {
    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        A[0] %= K;
        for (int i = 1; i < N; ++i)
            A[i] = (A[i] + A[i - 1]) % K;

        int[] count = new int[K];
        count[0]++;
        for (int x : A)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v : count)
            ans += v * (v - 1) / 2;
        return ans;
    }
}
