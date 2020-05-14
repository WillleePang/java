package com.willlee.leetcode.problems501_600;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode503 {
    public static void main(String[] args) {
        Leetcode503 a = new Leetcode503();
        a.nextGreaterElements(new int[] { 1, 2, 1 });
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < n)
                stack.add(i);
        }
        return res;
    }
}
