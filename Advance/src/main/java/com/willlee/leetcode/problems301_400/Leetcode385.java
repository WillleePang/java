package com.willlee.leetcode.problems301_400;

import com.willlee.leetcode.utils.NestedInteger;

public class Leetcode385 {
    char[] chars;
    int cur = 0;

    public NestedInteger deserialize(String s) {
        chars = s.toCharArray();
        if (chars[0] != '[')
            return new NestedInteger(Integer.valueOf(s));
        return getNest();
    }

    private NestedInteger getNest() {
        NestedInteger nest = new NestedInteger();
        int num = 0;
        boolean negative = false;
        while (cur != chars.length) {
            cur++;
            if (chars[cur] == ',')
                continue;
            if (chars[cur] == '[') {// 需要新建一个integer类
                nest.add(getNest());
            } else if (chars[cur] == ']') {// 到末端返回
                return nest;
            } else if (chars[cur] == '-') {
                negative = true;
            } else {
                if (negative)
                    num = 10 * num - (chars[cur] - 48);
                else
                    num = 10 * num + (chars[cur] - 48);
                if (chars[cur + 1] == ',' || chars[cur + 1] == ']') {
                    nest.add(new NestedInteger(num));
                    num = 0;
                    negative = false;
                }
            }
        }
        return null;
    }
}
