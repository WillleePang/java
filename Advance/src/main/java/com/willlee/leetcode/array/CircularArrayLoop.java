package com.willlee.leetcode.array;

//leetcode457
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1)
            return false;
        int[] failure = new int[length];
        for (int i = 0; i < nums.length; ++i) {
            int cur = i;
            if (failure[cur] == 1)
                continue;
            int[] help = new int[length];
            int next;
            boolean flag = true;
            if (nums[cur] < 0)
                flag = false;
            while (true) {
                help[cur] = 1;
                failure[cur] = 1;
                if (flag)
                    next = (cur + nums[cur]) % length;
                else
                    next = cur + nums[cur] < 0 ? length - Math.abs(cur + nums[cur]) % length : cur + nums[cur];
                if (flag && nums[next] < 0)
                    break;
                if (!flag && nums[next] > 0)
                    break;
                if (help[next] == 1 && next != cur)// 走过，环闭合
                    return true;
                if (help[next] == 1 && next == cur)// 原地不动
                    break;
                cur = next;
            }
        }
        return false;
    }

    public static boolean circularArrayLoop1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int cirLen;
        int sign;
        for (int i = 0; i < nums.length; i++) {
            sign = 1;
            cirLen = 0;
            if (nums[i] < 0) {
                sign = -1;
            }
            int k = i;
            do {
                cirLen++;
                k = (k + nums[k]) % nums.length;
                if (k < 0) {
                    k = k + nums.length;
                }
            } while (cirLen <= nums.length && k != i && nums[k] * sign > 0);
            if (cirLen > 1 && cirLen <= nums.length && nums[k] * sign > 0) {
                return true;
            }
        }
        return false;
    }
}
