package com.willlee.leetcode.problems601_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//leetcode697
public class Leetcode697 {
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        Set<Integer> keySet = map.keySet();
        int count = 0;
        int length = 0;
        for (int key : keySet) {
            List<Integer> list = map.get(key);
            int size = list.size();
            if (size > count) {
                count = size;
                length = list.get(size - 1) - list.get(0) + 1;
            }
            if (size == count) {
                length = Math.min(length, list.get(size - 1) - list.get(0) + 1);
            }
        }
        return length;
    }

    public int findShortestSubArray1(int[] nums) {
        int[] b = new int[50000];
        for (int i : nums)
            b[i]++;
        int max = 0;
        for (int i = 0; i < 50000; i++) {
            max = Math.max(max, b[i]);
        }
        // 以上，获取当前数组的度

        int sum = 0;
        int c = 50000;
        for (int i = 0; i < 50000; i++) {
            if (b[i] == max) {
                int n = 0;
                int m = nums.length - 1;
                while (n < nums.length) {
                    if (nums[n] == i) {
                        sum -= n;
                        break;
                    } else {
                        n++;
                    }
                }
                while (m >= 0) {
                    if (nums[m] == i) {
                        sum += m;
                        break;
                    } else {
                        m--;
                    }
                }
                c = Math.min(c, sum + 1);
                sum = 0;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 2, 3, 1 };
        int findShortestSubArray = findShortestSubArray(a);
        System.out.println(findShortestSubArray);
    }
}
