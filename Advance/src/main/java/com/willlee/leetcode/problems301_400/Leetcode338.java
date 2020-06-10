package com.willlee.leetcode.problems301_400;

public class Leetcode338 {
    public static void main(String[] args) {
        Leetcode338 a = new Leetcode338();
        a.countBits(10);
    }

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }

    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            // x / 2 is x >> 1 and x % 2 is x & 1
            ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }

    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = Integer.bitCount(num);
        }
        return ans;
    }
}
