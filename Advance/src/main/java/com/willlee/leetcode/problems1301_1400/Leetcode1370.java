package com.willlee.leetcode.problems1301_1400;

public class Leetcode1370 {
    public static void main(String[] args) {
        Leetcode1370 a = new Leetcode1370();
        String sortString = a.sortString("leetcode");
        System.out.println(sortString);
    }

    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a'] += 1;
        StringBuilder res = new StringBuilder();
        while (res.length() != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (count[i] == 0)
                    continue;
                res.append((char) (i + 'a'));
                count[i] -= 1;
            }
            for (int i = 25; i >= 0; i--) {
                if (count[i] == 0)
                    continue;
                res.append((char) (i + 'a'));
                count[i] -= 1;
            }
        }
        return res.toString();
    }
}
