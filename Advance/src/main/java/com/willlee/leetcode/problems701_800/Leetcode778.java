package com.willlee.leetcode.problems701_800;

import java.util.PriorityQueue;

public class Leetcode778 {

    public int swimInWater1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dirs = { 0, 1, 0, -1, 0 };
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        boolean[][] visit = new boolean[n][m];
        pq.add(new int[] { 0, 0, grid[0][0] });
        visit[0][0] = true;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[0];
            int j = top[1];
            int hi = top[2];
            if (i == n - 1 && j == n - 1)
                return hi;
            for (int k = 0; k < 4; k++) {
                int dx = i + dirs[k];
                int dy = j + dirs[k + 1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m || visit[dx][dy])
                    continue;
                visit[dx][dy] = true;
                int max = Math.max(hi, grid[dx][dy]);
                pq.add(new int[] { dx, dy, max });
            }

        }
        return 0;
    }

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int ans = Math.max(grid[0][0], grid[N - 1][N - 1]);
        while (true) {
            change(0, 0, N, grid, ans + 1);
            if (grid[N - 1][N - 1] == ans + 1) {
                return ans;
            }
            ans++;
        }
    }

    private void change(int x, int y, int N, int[][] grid, int key) {
        if (grid[x][y] >= key) {
            return;
        }
        grid[x][y] = key;
        if (x > 0) {
            change(x - 1, y, N, grid, key);
        }
        if (y > 0) {
            change(x, y - 1, N, grid, key);
        }
        if (x < N - 1) {
            change(x + 1, y, N, grid, key);
        }
        if (y < N - 1) {
            change(x, y + 1, N, grid, key);
        }
    }

    public static void main(String[] args) {
        Leetcode778 a = new Leetcode778();
        a.swimInWater(new int[][] { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 }, { 10, 9, 8, 7, 6 } });
    }
}
