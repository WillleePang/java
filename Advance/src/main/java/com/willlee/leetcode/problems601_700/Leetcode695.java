package com.willlee.leetcode.problems601_700;

//leetcode695
public class Leetcode695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int max_area = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    max_area = Math.max(max_area, dfs(grid, i, j));
                }
            }
        }
        return max_area;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 + dfs(grid, row - 1, col) + dfs(grid, row, col - 1) + dfs(grid, row + 1, col)
                + dfs(grid, row, col + 1);
    }
}
