package com.willlee.leetcode.problems801_900;

public class Leetcode849 {

    /*
     * 
     * 思路
     * 
     * 遍历所有座位 seats，找出每个空位左边最近的人和右边最近的人，更新当前空位到最近的人的距离。
     * 
     * 算法
     * 
     * 使用 prev 记录 i 最左边第一个有人的位置，future 记录 i 最右边第一个有人的位置。
     * 
     * 座位 i 到最近的人的距离为 min(i - prev, future - i)。另外有一种特殊情况，如果座位 i
     * 左边没有人，则认为到左边第一个人的距离是无限大，右边同理。
     */
    public int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i)
                    future++;

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }
}
