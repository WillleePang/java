package com.willlee.leetcode.problems401_500;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    public static void main(String[] args) {
        Leetcode438 a = new Leetcode438();
        List<Integer> findAnagrams = a.findAnagrams("asdsdgertvgadsgwet", "vga");
        for (int i : findAnagrams) {
            System.out.println(i);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        List<Integer> ans = new ArrayList<>();
        int[] needs = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        int left = 0;
        int right = 0;
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            window[curR] += 1;

            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1
                window[curL] -= 1;

            }
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }
}
