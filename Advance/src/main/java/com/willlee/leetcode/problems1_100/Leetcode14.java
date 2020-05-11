package com.willlee.leetcode.problems1_100;

//leetcode14
public class Leetcode14 {
    // 横向查找
    public String longestCommonPrefix1(String[] arr) {
        if (arr == null || arr.length <= 0) {
            return "";
        }
        if (arr.length == 1) {
            return arr[0];
        }
        // 找到最短
        String min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < min.length()) {
                min = arr[i];
            }
        }
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < min.length(); i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].charAt(i) != arr[j + 1].charAt(i)) {
                    return str.toString();
                }
            }
            str.append(min.charAt(i));
        }
        return str.toString();
    }

    // 竖向查找
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // 分治
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return longestCommonPrefix3(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix3(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;// 分解任务
            String lcpLeft = longestCommonPrefix3(strs, l, mid);
            String lcpRight = longestCommonPrefix3(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        // 回溯合并两个字符串，提取出公共字符串
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    // 二分查找
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (CommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean CommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
