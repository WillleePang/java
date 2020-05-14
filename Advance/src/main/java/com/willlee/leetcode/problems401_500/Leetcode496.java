package com.willlee.leetcode.problems401_500;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode496 {
    public static void main(String[] args) {
        Leetcode496 a = new Leetcode496();
        a.nextGreaterElement(new int[] { 2, 1, 3 }, new int[] { 2, 3, 1 });
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n2; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < n1; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            map.put(nums2[i], i);
        }
        for (int j = 0; j < n1; j++) {
            ans[j] = -1;
            int index = map.get(nums1[j]);
            for (int k = index + 1; k < n2; k++) {
                if (nums2[k] > nums1[j]) {
                    ans[j] = nums2[k];
                    break;
                }
            }
        }
        return ans;
    }
}
