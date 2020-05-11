package com.willlee.leetcode.problems501_600;

//leetcode509
public class Leetcode509 {
    // 递归法(21ms,代码少，效率低)
    public int fib1(int N) {
        if (N == 0 || N == 1) {
            return N;
        } else {
            return fib1(N - 1) + fib1(N - 2);
        }
    }

    // 数组法(1ms,要操作数组,效率比操作整型低一点)
    public int fib2(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[N];
    }

    // 替换法(0ms,效率最高,内存消耗都差不多)
    public int fib3(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int x = 0, y = 1, z = 1, i = 0, end = N - 2;
        while (i <= end) {
            z = x + y;
            x = y;
            y = z;
            i++;
        }
        return z;
    }
}
