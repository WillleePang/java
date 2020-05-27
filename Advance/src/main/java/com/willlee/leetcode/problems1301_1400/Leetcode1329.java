package com.willlee.leetcode.problems1301_1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//1.找起点：两种情况：以第一行为起点；以第一列为起点;
//2.从起点开始，找对角线元素，然后把对角线元素赋值给list；对list元素排序然后把排序后的x元素放入原数组中;

public class Leetcode1329 {
    public int[][] diagonalSort(int[][] mat) {
        if (mat == null || mat.length == 0)
            return null;
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; i + j < n && j < m; j++) {
                temp.add(mat[j][i + j]);
            }
            Collections.sort(temp);
            for (int j = 0; i + j < n && j < m; j++) {
                mat[j][i + j] = temp.get(j);
            }
        }

        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; i + j < m && j < n; j++) {
                temp.add(mat[i + j][j]);
            }
            Collections.sort(temp);
            for (int j = 0; i + j < m && j < n; j++) {
                mat[i + j][j] = temp.get(j);
            }
        }
        return mat;
    }

    public int[][] diagonalSort1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp[] = new int[n];
            temp[count++] = mat[0][i];
            int j = 1, k = i + 1;
            while (j < m && k < n) {// 将一个对角线的元素存入数组中
                temp[count++] = (mat[j][k]);
                j++;
                k++;
            }
            Arrays.sort(temp, 0, count);// 对数组前count项进行排序
            int r = 0, l = i, count2 = 0;
            while (count > 0) {
                mat[r++][l++] = temp[count2++];// 替换原先的对角线元素
                count--;
            }

        }
        for (int i = 0; i < m; i++) {
            int temp[] = new int[m];
            temp[count++] = mat[i][0];
            int j = i + 1, k = 1;
            while (j < m && k < n) {
                temp[count++] = (mat[j][k]);
                j++;
                k++;
            }
            Arrays.sort(temp, 0, count);
            int r = i, l = 0, count2 = 0;
            while (count > 0) {
                mat[r++][l++] = temp[count2++];
                count--;
            }
        }
        return mat;
    }
}
