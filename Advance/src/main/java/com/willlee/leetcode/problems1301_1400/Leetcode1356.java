package com.willlee.leetcode.problems1301_1400;

import java.util.Arrays;

public class Leetcode1356 {

    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100_000 + arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100_000;
        }
        return arr;
    }

    public int[] sortByBits1(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 每次切分出来一个排好序的元素的索引 cut
        // arr[cut] 左边的元素都不大于他， 右边的元素都不小于他
        int cut = partition(arr, lo, hi);
        quickSort(arr, lo, cut - 1);
        quickSort(arr, cut + 1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {
        // 选择一个标记元素，一般选最左边或者最右边
        int temp = arr[hi];
        // 两个索引， cut 和 i
        int cut = lo;
        // 如果 arr[i] 比 temp 小的话，交换 arr[i] 和 arr[cut], 然后 cut++
        // 切分的实质就是把 temp 放到数组中合适的位置，该位置的索引就是 cut
        for (int i = lo; i < hi; i++) {
            // 如果二进制 1 的个数相等，则比较两个数的实际大小
            if (countBits(arr[i]) == countBits(temp)) {
                if (arr[i] < temp) {
                    swap(arr, i, cut);
                    cut++;
                }
            } else if (countBits(arr[i]) < countBits(temp)) {
                swap(arr, i, cut);
                cut++;
            }
        }
        swap(arr, cut, hi);
        return cut;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int countBits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

}
