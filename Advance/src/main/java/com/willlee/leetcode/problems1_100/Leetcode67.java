package com.willlee.leetcode.problems1_100;

public class Leetcode67 {
    public static String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            String temp = b;
            b = a;
            a = temp;
        }

        // a必然大于等于b
        StringBuilder c = new StringBuilder();
        int add = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0) {
            char m = a.charAt(i);
            char n = j >= 0 ? b.charAt(j) : 0;
            if (m == '1')
                add++;
            if (n == '1')
                add++;
            c.append(add % 2);
            add = add / 2;
            i--;
            j--;
        }
        if (add != 0) {
            c.append(add);
        }
        return c.reverse().toString();
    }

    public static void main(String[] args) {
        addBinary("101010100", "11110");
    }
}
