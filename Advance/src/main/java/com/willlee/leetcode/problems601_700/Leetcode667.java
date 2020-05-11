package com.willlee.leetcode.problems601_700;

//leetcode667
public class Leetcode667 {
    public int[] constructArray(int n, int k) {
        //下标从[0, k]中，偶数下标填充[1,2,3…]，奇数下标填充[k + 1, k, k - 1…]，后面[k + 1, n - 1]都是顺序填充
        int[] arr = new int[n];
        int s = 1, e = n, i = 0;
        while (s <= e) {
            if ((i < k && i % 2 == 0) || (i >= k && (k - 1) % 2 == 0))
                arr[i++] = s++;
            else
                arr[i++] = e--;
        }
        return arr;
    }
}
