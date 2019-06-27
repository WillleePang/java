package com.willlee.leetcode.array;

//leetcode74
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int num = -1, i = 0;
        while (i < matrix.length) {
            if (matrix[i].length != 0) {
                if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                    num = i;
                    break;
                }
            }
            i++;
        }
        if (num == -1)
            return false;
        i = 0;
        while (i < matrix[num].length) {
            if (matrix[num][i] == target)
                return true;
            i++;
        }
        return false;
    }
}
