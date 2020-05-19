package com.willlee.leetcode.problems1101_1200;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode1124 {
    public static void main(String[] args) {
        Leetcode1124 a = new Leetcode1124();
        int longestWPI = a.longestWPI2(new int[] { 9, 9, 6, 0, 6, 6, 9 });
        System.out.println(longestWPI);
    }

    public int longestWPI(int[] hours) {
        // 简化数据结构，大于8为1，小于等于为-1
        for (int i = 0; i < hours.length; i++) {
            hours[i] = (hours[i] > 8) ? 1 : -1;
        }
        // 计算前缀和
        int[] presum = new int[hours.length + 1];
        presum[0] = 0;
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + hours[i - 1];
        }
        // 两重暴力破解找出前缀和数组 presum 中两个索引 i 和 j，使 j - i 最大，且保证 presum[j] - presum[i]
        // 大于 0
        int longestWPI = 0;
        for (int i = 1; i < presum.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((presum[i] - presum[j]) > 0) {
                    longestWPI = Math.max((i - j), longestWPI);
                }
            }
        }
        return longestWPI;
    }

    public int longestWPI1(int[] hours) {
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] presum = new int[hours.length + 1];
        presum[0] = 0;
        for (int i = 1; i < presum.length; i++) {
            presum[i] = presum[i - 1] + hours[i - 1];
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < presum.length; i++) {
            if (!stack.isEmpty() && presum[stack.peek()] <= presum[i])
                continue;
            stack.push(i);
        }
        // 根据单调栈后序遍历数组计算最长上坡
        int longestWPI = 0;
        for (int i = presum.length - 1; i >= 0; i--) {
            if (presum[i] > presum[stack.peek()]) {
                longestWPI = Math.max(longestWPI, i - stack.peek());
                stack.pop();
                i++;
                if (stack.empty())
                    break;
                continue;
            }
        }
        return longestWPI;
    }

    public int longestWPI2(int[] hours) {
        int cur = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                cur++;
            } else {
                cur--;
            }
            if (cur > 0) {
                res = i + 1;
            } else {
                if (!map.containsKey(cur)) {
                    map.put(cur, i);
                }
                if (map.containsKey(cur - 1)) {
                    res = Math.max(res, i - map.get(cur - 1));
                }
            }
        }
        return res;
    }
}