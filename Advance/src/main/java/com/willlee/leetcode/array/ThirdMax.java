package com.willlee.leetcode.array;

import java.util.PriorityQueue;

//leetcode414
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        for (int num : nums) {
            max1 = Math.max(max1, num);
        }
        for (int num : nums) {
            if (num == max1) {
                continue;
            }
            max2 = Math.max(max2, num);
        }
        for (int num : nums) {
            if (num == max1 || num == max2) {
                continue;
            }
            max3 = Math.max(max3, num);
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }

    public int thirdMax1(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if ((queue.size() < 3 || nums[i] > queue.peek()) && !queue.contains(nums[i])) {
                queue.offer(nums[i]);
            }
            if (queue.size() > 3) {
                queue.poll();
            }
            max = Math.max(max, nums[i]);
        }
        return queue.size() < 3 ? max : queue.peek();
    }
}
