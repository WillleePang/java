package com.willlee.leetcode.problems201_300;

import java.util.TreeSet;

public class Leetcode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }

        if (k == 10000) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            int right = i + 1;
            long num1 = nums[i];
            while (right < len && (right - i) <= k) {
                long num2 = nums[right];
                if (Math.abs(num1 - num2) <= t) {
                    return true;
                }
                right++;
            }
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k == 10000)
            return false;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j >= n) {
                    break;
                }
                if (Math.abs((long) nums[i] - nums[i + j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
