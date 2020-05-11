package com.willlee.leetcode.problems201_300;

public class Leetcode264 {
    // 我们知道丑数序列是 1, 2, 3, 4, 5, 6, 8, 9...。
    //
    // 我们所有的丑数都是通过之前的丑数乘以 2, 3, 5 生成的，所以丑数序列可以看成下边的样子。
    //
    // 1, 1×2, 1×3, 2×2, 1×5, 2×3, 2×4, 3×3...。
    //
    // 我们可以把丑数分成三组，用丑数序列分别乘 2, 3, 5 。
    //
    // 乘 2: 1×2, 2×2, 3×2, 4×2, 5×2, 6×2, 8×2,9×2,…
    // 乘 3: 1×3, 2×3, 3×3, 4×3, 5×3, 6×3, 8×3,9×3,…
    // 乘 5: 1×5, 2×5, 3×5, 4×5, 5×5, 6×5, 8×5,9×5,…

    public int nthUglyNumber(int n) {
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2)
                a++;
            if (dp[i] == n3)
                b++;
            if (dp[i] == n5)
                c++;
        }
        return dp[n - 1];

    }
}
