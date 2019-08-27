package com.willlee.leetcode.array;

//leetcode670
public class MaximumSwap {
    // 先排序，再与原来的数字从高位开始对比，若该位不同，记原数字数组的当前数字为m，排序后数组的当前数字为n，那么在原数字数组中找到最低位值为n的数字，与m交换。复杂度为nlogn。
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int[] arr = new int[c.length];
        arr[c.length - 1] = c.length - 1;

        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] - '0' > max) {
                max = c[i] - '0';
                max_index = i;
            }
            arr[i] = max_index;
        }
        for (int i = 0; i < c.length; i++) {
            if (arr[i] != i && c[arr[i]] != c[i]) {
                char tmp = c[i];
                c[i] = c[arr[i]];
                c[arr[i]] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(c));
    }
}
