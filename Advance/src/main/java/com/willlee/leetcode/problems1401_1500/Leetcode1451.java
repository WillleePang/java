package com.willlee.leetcode.problems1401_1500;

import java.util.Arrays;

public class Leetcode1451 {
    public String arrangeWords(String text) {
        String[] s = text.toLowerCase().split(" ");
        Arrays.sort(s, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        char first = s[0].charAt(0);
        first = (char) (first - 32);
        String temp = first + s[0].substring(1);
        s[0] = temp;
        String res = "";
        res = String.join(" ", s);
        return res;
    }

    public String arrangeWords1(String text) {
        String[] arrs = text.split(" ");
        int min = Integer.MAX_VALUE;
        int max = 0;
        int length = arrs.length;
        int len = 0;
        for (int i = 0; i < length; i++) {
            len = arrs[i].length();
            if (len < min) {
                min = len;
            }
            if (len > max) {
                max = len;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (min <= max) {
            for (int i = 0; i < length; i++) {
                if (arrs[i].length() == min) {
                    if (i == 0) {
                        sb.append(arrs[i].toLowerCase()).append(" ");
                    } else {
                        sb.append(arrs[i]).append(" ");
                    }
                    arrs[i] = "";
                }
                if (i == length - 1) {
                    // 最后一次循环
                    min++;
                }
            }
        }
        char charFirst = sb.charAt(0);
        if (charFirst >= 97 && charFirst <= 122) {
            sb.setCharAt(0, (char) (charFirst - 32));
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
