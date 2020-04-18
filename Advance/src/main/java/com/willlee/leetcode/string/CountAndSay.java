package com.willlee.leetcode.string;

//leetcode38
public class CountAndSay {
    public String countAndSay(int n) {
        String cur = String.valueOf(1);
        for (int i = 1; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            // 循环上一个字符串，相同数字x的个数+x = nx
            for (int j = 0, k = 0; j < cur.length(); j = k) {
                while (k < cur.length() && cur.charAt(k) == cur.charAt(j)) {
                    ++k;
                }
                sb.append(k - j);// 相同数字x的个数
                sb.append(cur.charAt(j));// x
            }
            cur = sb.toString();
        }
        return cur;
    }
}
