package com.willlee.leetcode.problems1401_1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode1452 {
    public static void main(String[] args) {
        Leetcode1452 a = new Leetcode1452();
        List<List<String>> nums = new ArrayList<>();
        nums.add(Arrays.asList("leetcode", "google", "facebook"));
        nums.add(Arrays.asList("google", "microsoft"));
        nums.add(Arrays.asList("google", "facebook"));
        nums.add(Arrays.asList("goole"));
        nums.add(Arrays.asList("amazon"));
        a.peopleIndexes1(nums);
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList<>();
        int n = favoriteCompanies.size();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                List<String> companies1 = favoriteCompanies.get(i);
                List<String> companies2 = favoriteCompanies.get(j);
                Set<String> set = new HashSet<>(companies2);
                if (set.containsAll(companies1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> peopleIndexes1(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        // 1. 将字符串转换为数字
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (String s : favoriteCompanies.get(i))
                if (map.containsKey(s))
                    tmp.add(map.get(s));
                else {
                    map.put(s, map.size() + 1);
                    tmp.add(map.size());
                }
            list.add(tmp);
        }
        // 2. 将字符串中的数字从大到小排序
        for (List<Integer> l : list)
            Collections.sort(l);
        System.out.println(list);
        // 3. 判断是否是子集
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; flag && j < list.size(); j++) {
                if (list.get(i).size() >= list.get(j).size())
                    continue;
                List<Integer> l1 = list.get(i), l2 = list.get(j);
                int p1 = 0, p2 = 0;
                while (p1 < l1.size() && p2 < l2.size())
                    if (l1.get(p1).equals(l2.get(p2))) {
                        p1++;
                        p2++;
                    } else if (l1.get(p1).compareTo(l2.get(p2)) > 0)
                        p2++;
                    else
                        break;
                if (p1 == l1.size())
                    flag = false;
            }
            if (flag)
                ans.add(i);
        }
        return ans;
    }
}
