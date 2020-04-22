package com.willlee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Leetcode1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new LinkedList<>();
        Arrays.sort(folder);
        String pre = " ";
        for (String directory : folder) {
            int index = directory.indexOf(pre);
            int end = index + pre.length();
            if (index == -1 || (end < directory.length() && directory.charAt(end) != '/')) {
                result.add(directory);
                pre = directory;
            }
        }
        return result;
    }

    public List<String> removeSubfolders1(String[] folder) {
        Arrays.sort(folder, (s1, s2) -> s1.length() - s2.length());
        Set<String> set = new TreeSet<>((s1, s2) -> {
            if (s1.contains(s2 + "/"))
                return 0;
            return s1.compareTo(s2);
        });
        Collections.addAll(set, folder);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Leetcode1233 a = new Leetcode1233();
        a.removeSubfolders1(new String[] { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" });
    }
}
