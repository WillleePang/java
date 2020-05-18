package com.willlee.leetcode.problems1401_1500;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1410 {
    public static void main(String[] args) {
        Leetcode1410 a = new Leetcode1410();
        String entityParser = a.entityParser("&amp; is an &apos; but &ambassador; is &frasl;.I quote: &quot;...&quot;");
        System.out.println(entityParser);
    }

    public String entityParser(String text) {
        if (text.indexOf("&") == -1) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[] { 3, 4, 5, 6 };// i之后的几个字符，是否能组成字符实体
        Map<String, Character> map = new HashMap<>();
        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == '&') {
                boolean flag = false;
                for (int item : pos) {
                    String key = text.substring(i, i + item + 1);
                    if (map.containsKey(key)) {
                        flag = true;
                        sb.append(map.get(key));
                        i = i + item + 1;
                        break;
                    }
                }
                if (!flag) {
                    sb.append(text.charAt(i++));
                }
            } else {
                sb.append(text.charAt(i++));
            }
        }
        return sb.toString();
    }
}
