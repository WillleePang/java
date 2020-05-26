package com.willlee.leetcode.problems101_200;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode179 {

    public static void main(String[] args) {
        Leetcode179 a = new Leetcode179();
        a.largestNumber(new int[] { 3, 30, 34, 5, 9 });
    }

    public String largestNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i];
        }
        Arrays.sort(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                String s1 = n1 + "" + n2;
                String s2 = n2 + "" + n1;
                // compareTo 方法
                // 如果参数是一个按字典顺序排列等于该字符串的字符串，则返回值为0;
                // 如果参数是按字典顺序大于此字符串的字符串，则返回值小于0;
                // 如果参数是按字典顺序小于此字符串的字符串，则返回值大于0。
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(n[i]);
        }
        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
}
