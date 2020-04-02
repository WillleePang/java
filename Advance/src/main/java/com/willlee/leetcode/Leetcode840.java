package com.willlee.leetcode;

public class Leetcode840 {
    /*
     * 
     * 我们可以在代码中添加 if grid[r+1][c+1] != 5: continue，帮助我们略过一些循环，这是基于以下观察得出：
     * 
     * 网格的总和是45，因为网格必须是 1 到 9 不同的数字。
     * 
     * 每一列和行加起来必须是 15，乘以 3 则是网格的总和。
     * 
     * 对角线的和也必须是15，题目中说了对角线与列，行的和相同。
     * 
     * 将四条穿过中心的线的 12 个值相加（即一行一列两条对角线），这四条线加起来等于60；而整个网格加起来为 45。
     * 
     * 则中心等于 （60-45）/3 = 5（60−45）/3=5。
     * 
     */
    public int numMagicSquaresInside(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int ans = 0;
        for (int r = 0; r < R - 2; ++r)
            for (int c = 0; c < C - 2; ++c) {
                if (grid[r + 1][c + 1] != 5)
                    continue; // optional skip
                if (magic(grid[r][c], grid[r][c + 1], grid[r][c + 2], grid[r + 1][c], grid[r + 1][c + 1],
                        grid[r + 1][c + 2], grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2]))
                    ans++;
            }

        return ans;
    }

    public boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v : vals)
            count[v]++;
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 && vals[3] + vals[4] + vals[5] == 15
                && vals[6] + vals[7] + vals[8] == 15 && vals[0] + vals[3] + vals[6] == 15
                && vals[1] + vals[4] + vals[7] == 15 && vals[2] + vals[5] + vals[8] == 15
                && vals[0] + vals[4] + vals[8] == 15 && vals[2] + vals[4] + vals[6] == 15);
    }
}
