package com.willlee.leetcode.problems501_600;

import java.util.HashMap;
import java.util.Map;

//leetcode560
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        int s = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
            if (s == k) {
                ans++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (sum[j] - sum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 优化： 使用哈希表保存num[0:i]的和的频率
     */
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            // 检查是否存在 sum[j] + k == sum[i]
            int pSum = sum - k;
            if (map.containsKey(pSum)) {
                ans += map.get(pSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
