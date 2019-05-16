package com.willlee.leetcode.array;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return null;
    }

    /**
     * 解决思路是：
     * <p/>
     * 1.遍历数组，每拿到一个值就让 和数减去它得到余数
     * <p/>
     * 2.在Hash表中找是否有这个余数，有就返回下标， 没有就将这个值和对应下标存入Hash表
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        // 最好算一下初始容量，提高效率
        int initialCapacity = (int) ((float) nums.length / 0.75F + 1.0F);
        HashMap<Integer, Integer> map = new HashMap<>(initialCapacity);
        for (int i = 0; i < nums.length; i++) {
            // 在map中寻找余数
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
