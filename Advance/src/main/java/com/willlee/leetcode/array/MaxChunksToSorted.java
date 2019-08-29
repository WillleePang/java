package com.willlee.leetcode.array;

public class MaxChunksToSorted {
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

    // leetcode768
    // 思路：由于要达到局部有序且整体有序的效果，说明下一分组的最小值要大于或等于当前分组的最大值。
    // 令max[]数组保存从第一个数开始到当前数字之间的最大值。如arr=[2,1,3,4,4]，则max=[2,2,3,4,4];
    // 从后往前遍历，利用cmin记录最小值，不断与当前的最大值进行比较

    public int maxChunksToSorted2(int[] arr) {
        int[] max = new int[arr.length];
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            max[i] = Math.max(arr[i], max[i - 1]);
        int cmin = Integer.MAX_VALUE, re = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            // 确切地说，cmin记录的是arr[i+1]到最后一个数之间的最小值
            // 如果cmin >= max[i], 则i这里就是一个分割点
            if (cmin >= max[i])
                re++;
            cmin = Math.min(cmin, arr[i]);
        }
        return re;
    }

}
