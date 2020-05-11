package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.List;

//leetcode118
public class Leetcode118 {
    public static List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            triangle.add(list);
        }
        if (numRows == 2) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            triangle.add(list);
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            triangle.add(list);
        }
        if (numRows >= 3) {// 当杨辉三角大于三层的时候
            List<Integer> list = new ArrayList<>();
            list.add(1);
            triangle.add(list);
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            triangle.add(list);
            int i = 3;// 设定初始值为3
            int[] last = new int[] { 1, 1 };// 上层的数组的初始值
            while (i <= numRows) {// 从第三层开始循环
                int[] cur = new int[i];// 当前层数的数组
                cur[0] = 1;
                cur[i - 1] = 1;
                for (int j = 1; j <= i - 2; j++) {
                    cur[j] = last[j - 1] + last[j];
                }
                list = new ArrayList<>();
                for (int j = 0; j < cur.length; j++) {
                    list.add(cur[j]);
                }
                triangle.add(list);
                last = cur;
                i++;
            }
        }
        return triangle;
    }

    public static List<Integer> generate2(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        if (rowIndex == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            return list;
        }
        if (rowIndex >= 2) {// 当杨辉三角大于三层的时候
            int i = 3;// 设定初始值为3
            int[] last = new int[] { 1, 1 };// 上层的数组的初始值
            while (i <= rowIndex + 1) {// 从第三层开始循环
                int[] cur = new int[i];// 当前层数的数组
                cur[0] = 1;
                cur[i - 1] = 1;
                for (int j = 1; j <= i - 2; j++) {
                    cur[j] = last[j - 1] + last[j];
                }
                if (i == rowIndex + 1) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < cur.length; j++) {
                        list.add(cur[j]);
                    }
                    return list;
                }
                last = null;
                last = cur;
                i++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        generate1(10);
    }
}
