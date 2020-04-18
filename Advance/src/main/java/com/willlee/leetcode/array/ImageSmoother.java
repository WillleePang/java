package com.willlee.leetcode.array;

//leetcode661
public class ImageSmoother {
    int row = 0;
    int col = 0;

    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length < 1 || M[0] == null || M[0].length < 1) {
            return null;
        }
        row = M.length;
        col = M[0].length;
        int ans[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = calcul(M, i, j);
            }
        }
        return ans;
    }

    // 上、下、左、右，上左，上右，下左，下右
    int dirR[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
    int dirC[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

    private int calcul(int arr[][], int i, int j) {
        int count = 1;
        int sum = arr[i][j];

        for (int k = 0; k < dirR.length; k++) {
            int nextR = i + dirR[k];
            int nextC = j + dirC[k];

            if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) {
                count++;
                sum += arr[nextR][nextC];
            }
        }
        return sum / count;
    }
}
