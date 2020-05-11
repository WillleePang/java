package com.willlee.leetcode.problems601_700;

import java.util.HashMap;
import java.util.Map;

public class Leetcode659 {

    public static void main(String[] args) {
        Leetcode659 a = new Leetcode659();
        boolean possible = a.isPossible(new int[] { 1, 2, 3, 3, 4, 5 });
        System.out.println(possible);
    }

    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>(), tails = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
        }
        int ele;
        for (int i = 0; i < len; i++) {
            ele = nums[i];
            if (cnt.get(ele) == 0) {
                continue;
            } else if (tails.containsKey(ele) && tails.get(ele) > 0) {
                cnt.put(ele, cnt.get(ele) - 1);
                tails.put(ele, tails.get(ele) - 1);
                tails.put(ele + 1, tails.getOrDefault(ele + 1, 0) + 1);
            } else if (cnt.containsKey(ele + 1) && cnt.get(ele + 1) > 0 && cnt.containsKey(ele + 2)
                    && cnt.get(ele + 2) > 0) {
                cnt.put(ele, cnt.get(ele) - 1);
                cnt.put(ele + 1, cnt.get(ele + 1) - 1);
                cnt.put(ele + 2, cnt.get(ele + 2) - 1);
                tails.put(ele + 3, tails.getOrDefault(ele + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPossible1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            if (map.get(num) == 0)
                continue;
            int count = 0;
            while (map.containsKey(num) && map.get(num) > 0) {
                count++;
                if (count > 3 && map.get(num) <= map.get(num - 1))
                    break;
                map.put(num, map.get(num) - 1);
                num++;
            }
            if (count < 3)
                return false;
        }
        return true;
    }
}