package com.willlee.leetcode.problems301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pre = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (pre != nums1[i]) {
                    list.add(nums1[i]);
                    pre = nums1[i];
                }
                i++;
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
