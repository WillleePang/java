package com.willlee.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode71 {
    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "";
        }
        String[] arr = path.split("/", 0);
        Deque<String> st = new LinkedList<String>();
        for (String a : arr) {
            if (!a.equals("")) {
                if (!a.equals(".")) {
                    if (a.equals("..")) {
                        if (!st.isEmpty()) {
                            st.removeLast();
                        }
                    } else {
                        st.add(a);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (st.isEmpty()) {
            sb.append("/");

        } else {
            while (!st.isEmpty()) {
                sb.append("/").append(st.pop());
            }
        }
        return sb.toString();
    }
}
