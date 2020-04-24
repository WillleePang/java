package com.willlee.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        // 处理极端情况
        if (k == 1)
            return true;
        // 用hashmap统计出现的数字和其次数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 将统计的结果存到二维数组中
        int[][] mark = new int[map.size()][2];
        int q = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            mark[q][0] = entry.getKey();
            mark[q][1] = entry.getValue();
            q++;
        }
        // 把数组按第一列也就是出现的数字从小到大排序
        Arrays.sort(mark, (a, b) -> (a[0] - b[0]));
        // 从mark第一列中每次取出k个元素，首先判断它们是否连续，不连续则返回false
        // 连续的话则对应的mark第二列减去mark[j][1],即移除以mark[j][0]开头的所有长度为k的连续字串
        int len = mark.length;
        for (int j = 0; j <= len - k; j++) {
            if (mark[j][1] == 0)
                continue;
            for (int p = j; p <= j + k - 2; p++) {
                if (mark[p][0] != mark[p + 1][0] - 1)
                    return false;
            }
            for (int p = j + 1; p <= j + k - 1; p++) {
                mark[p][1] -= mark[j][1];
                if (mark[p][1] < 0)
                    return false;
            }
            mark[j][1] = 0;
        }
        // 判断数组中是否所有元素都已经被移除
        for (int j = 0; j < len; j++) {
            if (mark[j][1] != 0)
                return false;
        }
        return true;

    }

    public boolean isPossibleDivide1(int[] nums, int k) {
        int len = nums.length;

        if (len % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int needKSetCount = len / k; // 需要的集合数（每个集合个数为k）
        int kCount = 0; // 以下遍历过程集合数
        for (int num : nums) {
            int curNumCount = countMap.get(num);
            if (curNumCount == 0) {
                // 等于0说明被归到前面集合中了
                continue;
            }

            countMap.put(num, curNumCount - 1);
            for (int i = 1; i < k; i++) {
                int count = countMap.getOrDefault(num + i, 0);
                if (count == 0) {
                    // 等于0就说明以当前num为起点，找不到k个大小的连续集合
                    return false;
                }

                countMap.put(num + i, count - 1);
            }

            kCount++;
            // 当集合数已经达到需要的集合数，说明已经成功了
            if (kCount == needKSetCount) {
                return true;
            }
        }
        return true;
    }
}
