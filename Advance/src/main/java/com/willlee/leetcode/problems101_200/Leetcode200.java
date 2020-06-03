package com.willlee.leetcode.problems101_200;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode200 {
    public static void main(String[] args) {
        Leetcode200 a = new Leetcode200();
        int numIslands = a.numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } });
        System.out.println(numIslands);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    DFS(i, j, grid);
                }
            }
        }
        return ans;
    }

    private void DFS(int x, int y, char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (x < 0 || x >= rowLen || y < 0 || y >= colLen || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        DFS(x - 1, y, grid);
        DFS(x + 1, y, grid);
        DFS(x, y - 1, grid);
        DFS(x, y + 1, grid);
    }

    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_island = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_island;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<Integer>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return num_island;
    }

}
