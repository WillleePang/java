package com.willlee.leetcode.problems501_600;

import java.util.ArrayList;
import java.util.List;

public class Leetcode524 {
    public static void main(String[] args) {
        List<String> d = new ArrayList<String>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        d.add("alea");
        Leetcode524 a = new Leetcode524();
        String findLongestWord = a.findLongestWord("abpcplea", d);
        System.out.println(findLongestWord);
    }

    public String findLongestWord(String s, List<String> d) {
        String str = "";
        for (String sstr : d) {
            for (int i = 0, j = 0; i < s.length() && j < sstr.length(); i++) {
                if (s.charAt(i) == sstr.charAt(j))
                    j++;
                if (j == sstr.length()) {
                    if (sstr.length() > str.length() || (sstr.length() == str.length() && str.compareTo(sstr) > 0))
                        str = sstr;
                }
            }
        }
        return str;
    }

}
