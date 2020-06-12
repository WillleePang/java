package com.willlee.leetcode.problems601_700;

public class Leetcode647 {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length * 2 - 1; i++) { // 对每个可能的回文中心进行循环
            int left = i / 2; // 当中心是两个字母的间歇时i%2 = 1；当中心是字母时
                              // left==right都落在该字母的位置
            int right = left + i % 2;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }
}
