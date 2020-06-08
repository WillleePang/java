package com.willlee.leetcode.problems101_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Leetcode140 {
	public static void main(String[] args) {
		Leetcode140 a = new Leetcode140();
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("cats");
		list.add("and");
		list.add("sand");
		list.add("a");
		a.wordBreak("a", list);
	}

	// BFS 超时
	public List<String> wordBreak(String s, List<String> wordDict) {
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
