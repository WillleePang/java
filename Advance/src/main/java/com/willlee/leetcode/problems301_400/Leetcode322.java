package com.willlee.leetcode.problems301_400;

import java.util.Arrays;

public class Leetcode322 {
    public static void main(String[] args) {
        Leetcode322 a = new Leetcode322();
        int coinChange = a.coinChange3(new int[] { 186, 419, 83, 408 }, 6249);
        System.out.println(coinChange);
    }

    // *****************************动态规划********************************//
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // *****************************暴力递归********************************//
    int res = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        findWay(coins, amount, 0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int i = 0; i < coins.length; i++) {
            findWay(coins, amount - coins[i], count + 1);
        }
    }
    // *****************************记忆化搜索********************************//
    // 可以看出在进行递归的时候，有很多重复的节点要进行操作，这样会浪费很多的时间。
    // 使用数组 memo[] 来保存节点的值
    // memo[n] 表示钱币 n 可以被换取的最少的硬币数，不能换取就为 −1
    // findWay 函数的目的是为了找到 amount 数量的零钱可以兑换的最少硬币数量，返回其值 int

    int[] memo;

    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];

        return findWay(coins, amount);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];
    }

    // *****************************记忆化搜索********************************//
    int ans = Integer.MAX_VALUE;

    public int coinChange3(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void dfs(int[] coins, int index, int amount, int cnt) {
        if (index < 0) {
            return;
        }
        for (int c = amount / coins[index]; c >= 0; c--) {
            int na = amount - c * coins[index];
            int ncnt = cnt + c;
            if (na == 0) {
                ans = Math.min(ans, ncnt);
                break;// 剪枝1
            }
            if (ncnt + 1 >= ans) {
                break; // 剪枝2
            }
            dfs(coins, index - 1, na, ncnt);
        }
    }
}
