package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Leetcode140 {
    // BFS 超时
    public List<String> wordBreak(String s, List<String> wordDict) {
        Stack<Leetcode140Pair> stack = new Stack<>();
        Map<Integer, String> ans = new HashMap<>();
        for (String word : wordDict) {
            if (word.length() > s.length()) {
                continue;
            }
            if (s.substring(0, word.length()).equals(word)) {
                stack.push(new Leetcode140Pair(word.length(), word));
            }
        }
        while (!stack.isEmpty()) {
            Leetcode140Pair pair = stack.pop();
            int index = pair.index;
            if (index == s.length()) {
                ans.put(pair.index, pair.content);
            }
            for (String word : wordDict) {
                if (index + word.length() > s.length()) {
                    continue;
                }
                if (s.substring(index, index + word.length()).equals(word)) {
                    String content = pair.content + " " + word;
                    stack.push(new Leetcode140Pair(index + word.length(), content));
                }
            }
        }
        return new ArrayList<>(ans.values());
    }

}

class Leetcode140Pair {
    public int index;
    public String content;

    public Leetcode140Pair(int index, String content) {
        this.index = index;
        this.content = content;
    }

    @Override
    public String toString() {
        return index + " " + content;
    }
}