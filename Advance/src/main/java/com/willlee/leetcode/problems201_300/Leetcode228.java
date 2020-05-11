package com.willlee.leetcode.problems201_300;

import java.util.ArrayList;
import java.util.List;

//leetcode228
public class Leetcode228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = nums[0];
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) > 1) {
                res.add((nums[i - 1] == left) ? left + "" : left + "->" + nums[i - 1]);
                left = nums[i];
            }
            if (i == nums.length - 1) {
                if (left == nums[i]) {
                    res.add(nums[i] + "");
                } else {
                    res.add(left + "->" + nums[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] { -2147483648, -2147483647, 2147483647 };
        List<String> summaryRanges = summaryRanges(a);
        for (String s : summaryRanges) {
            System.out.println(s);
        }
    }
}
