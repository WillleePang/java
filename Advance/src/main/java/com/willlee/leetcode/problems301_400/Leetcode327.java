package com.willlee.leetcode.problems301_400;

import java.util.HashMap;
import java.util.TreeSet;

public class Leetcode327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // 前缀和
        long[] prefix = new long[n + 1];
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i - 1] + nums[i - 1];
        }

        // 离散化
        for (long val : prefix) {
            set.add(val - lower);
            set.add(val);
            set.add(val - upper);
        }
        HashMap<Long, Integer> map = new HashMap<>();
        int rank = 1;
        while (!set.isEmpty()) {
            map.put(set.pollFirst(), rank++);
        }
        // 树状数组
        BIT bit = new BIT(rank);
        int ans = 0;
        for (long val : prefix) {
            int high_rank = map.get(val - lower);
            int low_rank = map.get(val - upper);
            rank = map.get(val);
            ans += bit.prefix(high_rank) - bit.prefix(low_rank - 1);
            bit.update(rank, 1);
        }
        return ans;
    }

    class BIT {
        int[] bit;
        int n;

        BIT(int n) {
            this.n = n + 1;
            bit = new int[n + 1];
        }

        public int lowBit(int i) {
            return i & (-i);
        }

        public void update(int i, int val) {
            while (i < n) {
                bit[i] += val;
                i += lowBit(i);
            }
        }

        public int prefix(int i) {
            int ans = 0;
            while (i > 0) {
                ans += bit[i];
                i -= lowBit(i);
            }
            return ans;
        }
    }
}
