package com.willlee.dynamicprogramming;

/**
 * 
 * 游戏规则是这样的：你和你的朋友面前有⼀排石头堆，⽤⼀个数组 piles 表示，piles[i] 表示第 i
 * 堆石子有多少个。你们轮流拿石头，⼀次拿⼀堆，但是 只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头 多，谁获胜。
 * 
 * @author pangweili
 *
 */
public class StoneGame {
    int play(int[] piles) {
        int n = piles.length;
        // 初始化dp数组
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        // 填入base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        // 遍历数组
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                // 先手选择最左边或者最右边的分数
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[i] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.fir - res.sec;
    }
}

class Pair {
    int fir, sec;

    Pair(int fir, int sec) {
        this.fir = fir;
        this.sec = sec;
    }
}
