package com.willlee.leetcode.math;

import java.util.HashMap;

public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        hashmap.put('I', 1);
        hashmap.put('V', 5);
        hashmap.put('X', 10);
        hashmap.put('L', 50);
        hashmap.put('C', 100);
        hashmap.put('D', 500);
        hashmap.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (hashmap.get(s.charAt(i)) >= hashmap.get(s.charAt(i + 1))) {
                sum += hashmap.get(s.charAt(i));
            } else {
                sum -= hashmap.get(s.charAt(i));
            }
        }
        return sum + hashmap.get(s.charAt(s.length() - 1));
    }

}
