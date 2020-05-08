package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode864 {
    private int target = 0;

    private int startRow = 0;

    private int startCol = 0;

    private int row;

    private int col;

    private int pathNum = -1;

    private int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private int[][][] dis;

    public int shortestPathAllKeys(String[] grid) {
        this.row = grid.length;
        this.col = grid[0].length();
        dis = new int[row][col][1 << 6];
        for (int[][] di : dis) {
            for (int[] dd : di) {
                Arrays.fill(dd, row * col);
            }
        }

        char[][] charGrid = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                charGrid[i][j] = grid[i].charAt(j);
                if (charGrid[i][j] >= 'a' && charGrid[i][j] <= 'f') {
                    target |= 1 << (grid[i].charAt(j) - 'a');
                }
                if (charGrid[i][j] == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        List<int[]> nodeList = new ArrayList<>();
        // [行数，列数，步数，获得锁的数量]
        nodeList.add(new int[] { startRow, startCol, 0, 0 });
        dis[startRow][startCol][0] = 0;
        bfs(nodeList, charGrid);
        return pathNum;
    }

    private void bfs(List<int[]> nodeList, char[][] charGrid) {
        List<int[]> nextList = new ArrayList<>();
        for (int[] point : nodeList) {
            int step = point[2];
            int key = point[3];
            if (key == target) {
                pathNum = step;
                return;
            }
            for (int[] direction : directions) {
                int newRow = point[0] + direction[0];
                int newCol = point[1] + direction[1];
                if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col) {
                    continue;
                }
                // 无法通过墙
                char ch = charGrid[newRow][newCol];
                if (ch == '#') {
                    continue;
                }

                int nextKey = key;
                // 无钥匙无法通过锁
                if (ch >= 'A' && ch <= 'F' && (key & 1 << (ch - 'A')) == 0) {
                    continue;
                }

                if (ch >= 'a' && ch <= 'f') {
                    nextKey = key | (1 << (ch - 'a'));
                }
                if (dis[newRow][newCol][nextKey] <= step + 1) {
                    continue;
                }
                dis[newRow][newCol][nextKey] = step + 1;
                nextList.add(new int[] { newRow, newCol, step + 1, nextKey });
            }
        }
        if (nextList.size() != 0) {
            bfs(nextList, charGrid);
        }
    }

    public static void main(String[] args) {
        System.out.println(1 << 6);
    }
}
