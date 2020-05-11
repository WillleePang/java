package com.willlee.leetcode.problems1301_1400;

import java.util.Arrays;

public class Leetcode1337 {
    // 将每一行的士兵数量x1000+索引存到一个新的列表里，然后对这个列表进行排序，取前面的k位对1000取余即是需要的索引值。
    // 将数字扩大一百倍以后，加上索引的数值也不会对排序有任何影响，因为数量级不够
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] list = new int[mat.length];
        int[] result = new int[k];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int n : mat[i]) {
                if (n != 1) {
                    break;
                }
                sum += n;
            }
            list[i] = sum * 100 + i;
        }
        Arrays.sort(list);
        for (int i = 0; i < k; i++) {
            result[i] = list[i] % 100;
        }
        return result;
    }

}
