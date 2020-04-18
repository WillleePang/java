package com.willlee.leetcode.array;

//leetcode48
public class rotateMatrix {
    public void rotate(int[][] matrix) {
        int mod = matrix.length;
        int matrixLength = matrix.length;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < mod - 1; j++) {
                // m[a][b] = m[length-b-1][a]
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[matrixLength - (i + j) - 1][i];
                matrix[matrixLength - (i + j) - 1][i] = matrix[matrix.length - i - 1][matrixLength - (i + j) - 1];
                matrix[matrix.length - i - 1][matrixLength - (i + j)
                        - 1] = matrix[matrixLength - (matrixLength - (i + j) - 1) - 1][matrix.length - i - 1];
                matrix[i + j][matrix.length - i - 1] = temp;
            }
            mod -= 2;
        }
    }
}
