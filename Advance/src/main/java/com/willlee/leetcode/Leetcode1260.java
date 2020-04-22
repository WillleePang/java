package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        // Repeat the transform k times.
        for (; k > 0; k--) {
            // We'll write the transform into a new 2D array.
            int[][] newGrid = new int[grid.length][grid[0].length];

            // Case #1: Move everything not in the last column.
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 1; col++) {
                    newGrid[row][col + 1] = grid[row][col];
                }
            }

            // Case #2: Move everything in last column, but not last row.
            for (int row = 0; row < grid.length - 1; row++) {
                newGrid[row + 1][0] = grid[row][grid[0].length - 1];
            }

            // Case #3: Move the bottom right.
            newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];

            // Update grid to be the transformed grid.
            grid = newGrid;
        }

        // Copy the grid into a list for returning.
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row)
                listRow.add(v);
        }

        return result;
    }

    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        // Repeat the transform k times.
        for (; k > 0; k--) {

            int previous = grid[grid.length - 1][grid[0].length - 1];
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    int temp = grid[row][col];
                    grid[row][col] = previous;
                    previous = temp;
                }
            }
        }

        // Copy the grid into a list for returning.
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row)
                listRow.add(v);
        }

        return result;
    }

    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {

        int numCols = grid[0].length;
        int numRows = grid.length;

        // Setup the 2d list.
        List<List<Integer>> newGrid = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> newRow = new ArrayList<>();
            newGrid.add(newRow);
            for (int col = 0; col < numCols; col++) {
                newRow.add(0);
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int newCol = (col + k) % numCols;
                int wrapAroundCount = (col + k) / numCols;
                int newRow = (row + wrapAroundCount) % numRows;
                newGrid.get(newRow).set(newCol, grid[row][col]);
            }
        }

        return newGrid;
    }

}
