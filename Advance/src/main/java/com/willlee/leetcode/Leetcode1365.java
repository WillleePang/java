package com.willlee.leetcode;

import java.util.Arrays;

public class Leetcode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[i] = 0;
            for (int j = 0; j < copy.length; j++) {
                if (copy[j] < nums[i]) {
                    count[i]++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int[] smallerNumbersThanCurrent1(int[] nums) {
        // 统计出现频率 frequency
        int[] freq = new int[101]; // 索引即数值
        for (int num : nums)
            freq[num]++;

        // 对频率(而非对原数组nums)从前到后累加
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        // 输出结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (nums[i] > 0)
                res[i] = freq[nums[i] - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1365 a = new Leetcode1365();
        int[] smallerNumbersThanCurrent = a.smallerNumbersThanCurrent(new int[] { 6, 5, 4, 8 });
        for (int i = 0; i < smallerNumbersThanCurrent.length; i++) {
            System.out.println(smallerNumbersThanCurrent[i]);
        }
    }
}
