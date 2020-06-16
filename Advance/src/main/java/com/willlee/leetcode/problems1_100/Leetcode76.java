package com.willlee.leetcode.problems1_100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Leetcode76 {

    public static void main(String[] args) {
        Leetcode76 a = new Leetcode76();
        a.minWindow("ADOBECODEBANC", "ABC");
    }

    Map<Character, Integer> current = new HashMap<Character, Integer>();
    Map<Character, Integer> count = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (++r < sLen) {
            if (count.containsKey(s.charAt(r))) {
                current.put(s.charAt(r), current.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (count.containsKey(s.charAt(l))) {
                    current.put(s.charAt(l), current.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator<Entry<Character, Integer>> iter = count.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<Character, Integer> entry = iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (current.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public String minWindow1(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        // 用来统计t中每个字符出现次数
        int[] needs = new int[128];
        // 用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        // 目前有多少个字符
        int count = 0;

        // 用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }

            // 移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                window[ch]--;
                left++;

            }
            right++;

        }
        return res;
    }

}
