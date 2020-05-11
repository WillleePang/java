package com.willlee.leetcode.problems701_800;

public class leetcode769 {
    // leetcode769
    // 由于数组arr的特殊性，arr[:i+1]的最大值left_max只存在两种情况：
    // left_max==i，则右边的最小值一定大于i，可以作为一个切分点
    // left_max>i，则右边一定存在小于i的数，则不可以作为切分点
    public int maxChunksToSorted1(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int ret = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ret++;
            }
        }
        return ret;
    }
}
