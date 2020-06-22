package com.willlee.leetcode.problems301_400;

public class Leetcode304 {
	public static void main(String[] args) {
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		NumMatrix m = new NumMatrix(matrix);
		m.sumRegion(0, 0, 1, 2);
	}
}

class NumMatrix {
	private int[][] dp;

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		dp = new int[matrix.length + 1][matrix[0].length + 1];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}
}

class NumMatrix1 {

	int[][] _matrix;

	public NumMatrix1(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			_matrix = null;
		} else {
			int n = matrix[0].length;
			_matrix = new int[m][n];
			_matrix[0][0] = matrix[0][0];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					_matrix[i][j] = matrix[i][j];
					_matrix[i][j] += i - 1 < 0 ? 0 : _matrix[i - 1][j];
					_matrix[i][j] += j - 1 < 0 ? 0 : _matrix[i][j - 1];
					_matrix[i][j] -= (i - 1 < 0 || j - 1 < 0) ? 0 : _matrix[i - 1][j - 1];
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (_matrix == null) {
			return -1;
		}
		int num1 = _matrix[row2][col2];
		int num2 = row1 - 1 < 0 ? 0 : _matrix[row1 - 1][col2];
		int num3 = col1 - 1 < 0 ? 0 : _matrix[row2][col1 - 1];
		int num4 = (row1 - 1 < 0 || col1 - 1 < 0) ? 0 : _matrix[row1 - 1][col1 - 1];
		return num1 - num2 - num3 + num4;
	}
}