package com.willlee.leetcode.problems1201_1300;

public class Leetcode1209 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int length = -1;
        while (length != sb.length()) {
            length = sb.length();
            for (int i = 0, count = 1; i < sb.length(); i++) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else if (++count == k) {
                    sb.delete(i - k + 1, i + 1);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String removeDuplicates1(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                count[i] = 1;
            } else {
                count[i] = count[i - 1] + 1;
                if (count[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }

    public String removeDuplicates2(String s, int k) {
        for (int i = 1, len = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                len = 1;
            }
            if (len == k) {
                return removeDuplicates2(s.substring(0, i - k + 1) + s.substring(i + 1), k);
            }
        }
        return s;
    }
}
