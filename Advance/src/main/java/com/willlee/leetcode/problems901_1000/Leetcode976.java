package com.willlee.leetcode.problems901_1000;

import java.util.Arrays;

public class Leetcode976 {
    // 从大到小排序后，一次遍历即可。最大的且满足三角形的一定是连续的子数组，至于为什么，自己想想用反证法就可以推导了。
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i + 1] > A[i + 2])
                return A[i] + A[i + 1] + A[i + 2];
        return 0;
    }
}
