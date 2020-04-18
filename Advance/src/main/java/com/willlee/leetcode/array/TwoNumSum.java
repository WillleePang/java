package com.willlee.leetcode.array;

//leetcode 167
public class TwoNumSum {
    public int[] twoSum(int[] number, int target) {
        int i = 0, j = number.length - 1;
        int[] ret = new int[2];
        while (i < j) {
            int sum = number[i] + number[j];
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }
            if (sum == target) {
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            }
        }
        return ret;
    }
}
