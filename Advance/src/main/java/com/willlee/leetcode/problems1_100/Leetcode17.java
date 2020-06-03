package com.willlee.leetcode.problems1_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode17 {
    HashMap<String, String> phone = new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    String[] letter_map = { " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    // 最终输出结果的list
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations1(String digits) {
        // 注意边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, "", 0);
        return res;
    }

    // 递归函数
    void iterStr(String str, String letter, int index) {
        if (index == str.length()) {
            res.add(letter);
            return;
        }
        char c = str.charAt(index);
        int pos = c - '0';
        String map_string = letter_map[pos];
        for (int i = 0; i < map_string.length(); i++) {
            iterStr(str, letter + map_string.charAt(i), index + 1);
        }
    }

}
