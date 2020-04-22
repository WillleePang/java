package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        List<Boolean> res = new ArrayList<>();

        // 回文串必须全部是偶数 或者 至多存在一个奇数
        // 能否变成回文串那么就需要看给定步数是否能够将多余的奇数变成偶数
        //
        // 比如 abcd，我们需要 2 步，将 cd 变成 ab，那么就能构成回文串 abba
        // 比如 abcde，我们需要 2 步，将 cd 变成 ab, 那么就能构成回文串 abeba
        //
        // 因此，我们需要步数是，奇数的个数 c / 2

        for (int[] q : queries) {
            int[] chs = new int[26];
            for (int i = q[0]; i <= q[1]; i++) {
                chs[s.charAt(i) - 'a']++;
            }
            // 计算奇数的个数
            int c = 0;
            for (int i = 0; i < 26; i++) {
                if ((chs[i] & 1) != 0) {
                    c++;
                }
            }
            if (c / 2 > q[2]) {
                res.add(false);
            } else {
                res.add(true);
            }
        }
        return res;
    }

    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        // 预处理，处理从 [0, len] 每个段 的所有字符出现情况，比如 [0, 0] 26个字母出现的起情况，[0, 1] 26
        // 个字母出现的情况，[0, 2] 26 个字母出现的情况
        int[][] count = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++) {
            System.arraycopy(count[i - 1], 0, count[i], 0, 26);
            count[i][s.charAt(i - 1) - 'a']++;
        }
        for (int[] q : queries) {
            // 通过 [0, right] 和 [0, left] 的字符统计情况，我们可以得到 [left, right] 的字符统计情况
            int[] chs = new int[26];
            int left = q[0];
            int right = q[1];
            for (int i = 0; i < 26; i++) {
                chs[i] = count[left][i] - count[right + 1][i];
            }
            // 计算奇数的个数
            int c = 0;
            for (int i = 0; i < 26; i++) {
                if ((chs[i] & 1) != 0) {
                    c++;
                }
            }
            if (c / 2 > q[2]) {
                res.add(false);
            } else {
                res.add(true);
            }
        }
        return res;
    }
}
