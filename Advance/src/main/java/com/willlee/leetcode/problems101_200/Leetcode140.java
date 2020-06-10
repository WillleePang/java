package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Leetcode140 {
    public static void main(String[] args) {
        Leetcode140 a = new Leetcode140();
        List<String> list = new ArrayList<String>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        a.wordBreak("catsanddog", list);
    }

    List<String> ans;
    Set<Integer> lenset;// 长度种类
    Set<String> wordSet;// 单词的字典，方便查询
    String s;
    int[][] dp;// 进行记忆化剪枝的数组

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        lenset = new HashSet<>();
        wordSet = new HashSet<>(wordDict);
        this.s = s;
        int max = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            max = Math.max(max, wordDict.get(i).length());
            lenset.add(wordDict.get(i).length());
            wordSet.add(wordDict.get(i));
        }
        dp = new int[s.length() + 1][max + 1];
        helper(new ArrayList<String>(), 0);
        return ans;
    }

    private int helper(List<String> temp, int start) {
        if (start == s.length()) {
            // 能够正确拆分单词，返回1
            ans.add(gen(temp));
            return 1;
        }
        boolean ok = false;// 标记
        for (int len : lenset) {
            if (start + len <= s.length()) {
                String st = s.substring(start, start + len);
                if (wordSet.contains(st) && dp[start][len] != -1) {// 如果已经不可拆分，直接剪枝
                    temp.add(st);
                    dp[start][len] = helper(temp, start + len);
                    if (dp[start][len] == 1)
                        ok = true;
                    temp.remove(temp.size() - 1);
                }
            }
        }
        if (ok == false)
            return -1;
        else
            return 1;
    }

    private String gen(List<String> str) {
        // 生成给定的输出模型
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String s : str) {
            if (first) {
                first = false;
                sb.append(s);
            } else
                sb.append(" ").append(s);
        }
        return sb.toString();
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>(wordDict);
        return word_Break(s, set, 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    // BFS 超时
    public List<String> wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>(wordDict);
        List<String> ans = new ArrayList<String>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int start = stack.pop();
            for (int end = start + 1; end <= s.length(); end++) {
                if (set.contains(s.substring(start, end))) {
                    if (map.containsKey(start)) {
                        map.put(end, map.get(start) + " " + s.substring(start, end));
                    } else {
                        map.put(end, s.substring(start, end));
                    }
                    if (end == s.length()) {
                        ans.add(map.get(end));
                    } else {
                        stack.push(end);
                    }
                }
            }
        }
        return ans;
    }
}
