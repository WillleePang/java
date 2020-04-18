package com.willlee.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode954 {
    public boolean canReorderDoubled(int[] A) {
        // count[x] = the number of occurrences of x in A
        // count[x] 是A数组中x出现的次数
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int x : A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // B = A as Integer[], sorted by absolute value
        // 新创建一个数组B，根据绝对值排序
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; ++i)
            B[i] = A[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        for (int x : B) {
            // If this can't be consumed, skip
            // x已经已经被消费了，跳过
            if (count.get(x) == 0)
                continue;
            // If this doesn't have a doubled partner, the answer is false
            // 如果2*x不存在，那么直接返回false
            if (count.getOrDefault(2 * x, 0) <= 0)
                return false;

            // Write x, 2*x
            count.put(x, count.get(x) - 1);
            count.put(2 * x, count.get(2 * x) - 1);
        }

        // If we have written everything, the answer is true
        return true;
    }

    public boolean canReorderDoubled1(int[] A) {
        Arrays.sort(A);
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        while (i < A.length) {
            if (deque.peekFirst() == null) {
                if (A[i] < 0) {
                    deque.addLast(A[i] / 2);
                } else {
                    deque.addLast(A[i] * 2);
                }
            } else if (deque.peekFirst() != null) {
                if (deque.peekFirst() == A[i]) {
                    deque.pollFirst();
                } else {
                    if (deque.peekFirst() > A[i]) {
                        if (A[i] < 0) {
                            deque.addLast(A[i] / 2);
                        } else {
                            deque.addLast(A[i] * 2);
                        }
                    } else {// 当数组元素不等于队列的首位元素,且该元素大于队列首位元素时,直接返回false
                        return false;
                    }
                }
            }
            i++;
        }
        if (deque.peekFirst() != null) {
            return false;
        }
        return true;
    }
}
