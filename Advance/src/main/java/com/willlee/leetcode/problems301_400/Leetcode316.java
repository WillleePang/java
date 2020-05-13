package com.willlee.leetcode.problems301_400;

import java.util.Stack;

public class Leetcode316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            // 找到左侧第一个已经无重复次数且最小的字符
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (--count[s.charAt(i) - 'a'] == 0)
                break;
        }
        // 将字符从串中删除，并且需找下一个
        return s.length() == 0 ? ""
                : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public String removeDuplicateLetters1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.contains(c)) {
                continue;
            }
            // 若当前的栈顶元素比当前的元素字典序大，且当前元素的位置后面还有栈顶元素,将栈顶元素出栈, 将当前元素入栈, 这样来找到最优的排列
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicateLetters2(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        boolean[] useFlag = new boolean[26];
        char[] chr = s.toCharArray();
        for (char c : chr) {
            count[c - 'a']++;
        }
        for (char c : chr) {
            count[c - 'a']--;
            if (useFlag[c - 'a'])//如果访问过，测继续循环
                continue;
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                useFlag[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            useFlag[c - 'a'] = true;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode316 a = new Leetcode316();
        a.removeDuplicateLetters2("cbacdcbc");
    }
}
