package com.willlee.leetcode.array;

//leetcode775

public class IsIdealPermutation {
    /*
     * 一个局部倒置也是一个全局倒置，因此只需要检查有没有非局部倒置就可以了。这里的非局部倒置指的是 A[i] > A[j], i < j，其中 j -
     * i > 1。 需要检查是否存在满足 j >= i+2 的 A[i] > A[j]，这和检查 A[i] > min(A[i+2:]) 是等价的。
     * 如果提前计算出 min(A[0:]), min(A[1:]), min(A[2:]), ... 这些区间的最小值，就可以立即完成检查操作。
     */

    /*
     * 从右往左遍历数组 A，保存见到的最小的数。定义 floor = min(A[i:]) 来保存最小的数，如果 A[i-2] > floor，直接返回
     * False，当遍历结束都没有返回 False，返回 True。
     */
    public boolean isIdealPermutation(int[] A) {
        int N = A.length;
        int min = N;
        for (int i = min - 1; i >= 2; --i) {
            min = Math.min(min, A[i]);
            if (A[i - 2] > min)
                return false;
        }
        return true;
    }

    /*
     * 思路和算法 假设有一个长度为 n，其中元素为 0 到 n-1 的数组。对于这种数组，定义 理想 排列为该数组的一个不存在非局部倒置的排列。 对于
     * 理想 排列，0 应该在哪里呢？ 如果 0 的下标大于等于 2，一定会有 A[0] > A[2] = 0，这是一个非局部倒置。所以 0
     * 只能出现在下标 0 或者下标 1。当 A[1] = 0，显然 A[0] = 1，否则就会有 A[0] > A[j] =
     * 1，这也是一个非局部倒置。当 A[0] = 0，这时候问题就转化成了一个子问题。 根据上述讨论，可以归纳出 理想 数组的充分必要条件为
     * Math.abs(A[i] - i) <= 1。
     * 
     */
    public boolean isIdealPermutation1(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            if (Math.abs(A[i] - i) > 1)
                return false;
        }
        return true;
    }
}
