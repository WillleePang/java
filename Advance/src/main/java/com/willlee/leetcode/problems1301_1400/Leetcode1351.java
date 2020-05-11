package com.willlee.leetcode.problems1301_1400;

public class Leetcode1351 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] < 0) {
                count += (m - i) * n;
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    count += n - j;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode1351 a = new Leetcode1351();
        int b = a
                .countNegatives(new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } });
        System.out.println(b);
    }
}
