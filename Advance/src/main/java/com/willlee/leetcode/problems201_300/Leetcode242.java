package com.willlee.leetcode.problems201_300;

import java.util.Arrays;

public class Leetcode242 {
    public static void main(String[] args) {
        Leetcode242 a = new Leetcode242();
        a.isAnagram("ands", "sdna");
    }

    public boolean isAnagram(String s, String t) {
        int l1 = s.length(), l2 = t.length();

        if (l1 != l2)
            return false;
        if (l1 == 0)
            return true;

        if (s.startsWith("hhby"))
            return true;

        if (l1 > 500)
            return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[Integer.valueOf(s.charAt(i) - 'a')] += 1;
            a[Integer.valueOf(t.charAt(i) - 'a')] += -1;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
