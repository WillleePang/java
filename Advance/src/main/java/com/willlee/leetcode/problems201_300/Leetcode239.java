package com.willlee.leetcode.problems201_300;

import java.util.LinkedList;

public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面的数字小，则一次弹出，直至满足需求
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode239 a = new Leetcode239();
        a.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 7, 6 }, 8);
    }
}
