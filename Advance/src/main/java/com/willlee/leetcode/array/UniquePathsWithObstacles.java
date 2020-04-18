package com.willlee.leetcode.array;

//leetcode63
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] res = new int[col];
        res[col - 1] = obstacleGrid[row - 1][col - 1] ^ 1; // 初始化最后一个数
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int right = 0; // 当前值右边
                if (j < col - 1)
                    right = res[j + 1];
                res[j] = (obstacleGrid[i][j] ^ 1) * (res[j] + right);
            }
        }
        return res[0];
    }
}
