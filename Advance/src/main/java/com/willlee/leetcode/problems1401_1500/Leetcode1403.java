package com.willlee.leetcode.problems1401_1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1403 {
    public static void main(String[] args) {
        Leetcode1403 a = new Leetcode1403();
        a.minSubsequence1(new int[] { 4, 4, 7, 6, 7 });
    }

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        int remain = 0;
        int pick = 0;
        for (int i : nums) {
            remain += i;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            pick += nums[i];
            remain -= nums[i];
            list.add(nums[i]);
            if (pick > remain) {
                break;
            }
        }
        return list;
    }

    public List<Integer> minSubsequence1(int[] nums) {
        List<Integer> r = new ArrayList<>();
        if (nums.length < 2)
            r.add(nums[0]);
        else {
            int[] cs = new int[101];
            int sum = 0;
            int usum = 0;
            for (int i : nums) {
                cs[i]++;
                sum += i;
            }

            for (int i = 100; i >= 0 && (usum <= (sum - usum)); i--) {
                if (cs[i] != 0) {
                    while (cs[i] > 0 && (usum <= (sum - usum))) {
                        usum += i;
                        r.add(i);
                        cs[i]--;
                    }
                }
            }
        }
        return r;
    }
}
