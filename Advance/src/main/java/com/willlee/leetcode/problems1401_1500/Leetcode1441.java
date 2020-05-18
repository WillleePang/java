package com.willlee.leetcode.problems1401_1500;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1441 {
    public List<String> buildArray(int[] target, int n) {
        int[] a = new int[target[target.length - 1] + 1];
        for (int i = 0; i < target.length; i++) {
            a[target[i]] = 1;
        }
        List<String> ans = new ArrayList<String>();
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 1) {
                ans.add("Push");
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode1441 a = new Leetcode1441();
        a.buildArray(new int[] { 1, 3 }, 3);
    }
}
