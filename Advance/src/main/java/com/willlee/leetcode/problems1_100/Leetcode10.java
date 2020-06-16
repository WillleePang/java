package com.willlee.leetcode.problems1_100;

public class Leetcode10 {
    public boolean isMatch1(String s, String p) {
        // 如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (p.isEmpty())
            return s.isEmpty();
        // 判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {// 如果p的第一个元素的下一个元素是*
            // 则分别对两种情况进行判断
            return isMatch(s, p.substring(2)) || (headMatched && isMatch(s.substring(1), p));
        } else if (headMatched) {// 否则，如果s和p的首字符相等
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        // 需要分别取出s和p为空的情况，所以dp数组大小+1
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始化dp[0][0]=true,dp[0][1]和dp[1][0]~dp[s.length][0]默认值为false所以不需要显式初始化
        dp[0][0] = true;
        // 填写第一行dp[0][2]~dp[0][p.length]
        for (int k = 2; k <= p.length(); k++) {
            // p字符串的第2个字符是否等于'*',此时j元素需要0个，所以s不变p减除两个字符
            dp[0][k] = p.charAt(k - 1) == '*' && dp[0][k - 2];
        }
        // 填写dp数组剩余部分
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // p第j个字符是否为*
                if (p.charAt(j) == '*') {
                    // 两种情况:
                    // 1.s不变[i+1],p移除两个元素[j+1-2]。
                    // 2.比较s的i元素和p的j-1(因为此时j元素为*)元素,相等则移除首元素[i+1-1],p不变。
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || (dp[i][j + 1] && headMatched(s, p, i, j - 1));
                } else {
                    // s的i元素和p的j元素是否相等,相等则移除s的i元素[i+1-1]和p的j元素[j+1-1]
                    dp[i + 1][j + 1] = dp[i][j] && headMatched(s, p, i, j);
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    // 判断s第i个字符和p第j个字符是否匹配
    public boolean headMatched(String s, String p, int i, int j) {
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }
}
