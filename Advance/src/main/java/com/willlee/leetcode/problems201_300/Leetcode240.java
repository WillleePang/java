package com.willlee.leetcode.problems201_300;

public class Leetcode240 {
    public static void main(String[] args) {
        Leetcode240 a = new Leetcode240();
        int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
        boolean searchMatrix = a.searchMatrix1(matrix, 30);
        System.out.println(searchMatrix);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int column = matrix[0].length - 1;
        while (column >= 0 && row < matrix.length) {
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] > target)
                column--;
            else if (matrix[row][column] < target)
                row++;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int[][] matrix1 = new int[matrix.length][matrix[0].length];
        return ss(0, 0, matrix, target, matrix1);
    }

    private boolean ss(int x, int y, int[][] matrix, int target, int[][] matrix1) {
        if (x > matrix.length - 1 || y > matrix[0].length - 1) {
            return false;
        }
        if (matrix1[x][y] == 1) {
            return false;
        }
        matrix1[x][y] = 1;
        if (matrix[x][y] == target) {
            return true;
        }
        if (matrix[x][y] > target) {
            matrix[x][y] = -1;
            return false;
        }

        return ss(x + 1, y, matrix, target, matrix1) || ss(x, y + 1, matrix, target, matrix1);
    }
}
