package com.willlee.leetcode.problems301_400;

public class Leetcode331 {
    public static void main(String[] args) {
        Leetcode331 a = new Leetcode331();
        a.isValidSerialization("2,9,8,0,1,2,3,#,#,#,1,2,#,1,3,4,#");
    }

    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (String node : preorder.split(",")) {
            slots--;
            if (slots < 0)
                return false;
            if (!node.equals("#"))
                slots += 2;
        }
        return slots == 0;
    }

    public boolean isValidSerialization1(String preorder) {
        int slots = 1;
        int n = preorder.length();
        for (int i = 0; i < n; ++i) {
            if (preorder.charAt(i) == ',') {
                slots--;
                if (slots < 0)
                    return false;
                if (preorder.charAt(i - 1) != '#')
                    slots += 2;
            }
        }
        slots = (preorder.charAt(n - 1) == '#') ? slots - 1 : slots + 1;
        return slots == 0;
    }
}
