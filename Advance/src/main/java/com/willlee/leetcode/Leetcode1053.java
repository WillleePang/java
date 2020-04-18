package com.willlee.leetcode;

public class Leetcode1053 {
    // 题目要求既要比原数组小，又要在所有比原数组小的当中选最大，改动越靠后的数字影响越小，所以考虑逆序。
    // 对于第i个元素，查找靠右的剩下元素中既比i元素小，又尽量最大的元素，如果存在这样的元素，交换即可得到结果。
    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        for (int i = len - 2; i >= 0; --i) {
            int max = i + 1;
            for (int j = i + 1; j < len; j++) {
                if (A[j] > A[max] && A[j] < A[i])
                    max = j;
            }
            if (A[i] > A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
                return A;
            }
        }
        return A;
    }

    public int[] prevPermOpt11(int[] A) {
        int len = A.length;
        int curMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i + 1] < A[i]) { // 此处逆序，需要移动A[i]
                for (int j = i + 1; j < len; j++) { // 寻找与 A[i] 交换的位置
                    if (A[i] > A[j]) { // 必须满足 A[i] > A[j]，否则不能满足交换后的字典序小于原始字典序
                        hasResult = true;
                        if (A[j] > curMax) {
                            curMax = A[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    int tmp = A[i];
                    A[i] = A[index];
                    A[index] = tmp;
                    return A;
                }
            }
        }
        return A;
    }
}
