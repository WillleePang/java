package com.willlee.leetcode.problems701_800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Leetcode726 {
    public static void main(String[] args) {
        Leetcode726 a = new Leetcode726();
        a.countOfAtoms1("K4(ON(SO3)2)2");
    }

    int i;

    public String countOfAtoms(String formula) {
        StringBuilder ans = new StringBuilder();
        i = 0;
        Map<String, Integer> count = parse(formula);
        for (String name : count.keySet()) {
            ans.append(name);
            int multiplicity = count.get(name);
            if (multiplicity > 1)
                ans.append("" + multiplicity);
        }
        return new String(ans);
    }

    public Map<String, Integer> parse(String formula) {
        int N = formula.length();
        Map<String, Integer> count = new TreeMap<>();
        while (i < N && formula.charAt(i) != ')') {
            if (formula.charAt(i) == '(') {
                i++;
                for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            } else {
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i)))
                    i++;
                int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                count.put(name, count.getOrDefault(name, 0) + multiplicity);
            }
        }
        int iStart = ++i;
        while (i < N && Character.isDigit(formula.charAt(i)))
            i++;
        if (iStart < i) {
            int multiplicity = Integer.parseInt(formula.substring(iStart, i));
            for (String key : count.keySet()) {
                count.put(key, count.get(key) * multiplicity);
            }
        }
        return count;
    }

    /**
     * 方法：栈，直接使用count栈来模拟调用堆栈代替递归 时间复杂度：O(n^2)，空间复杂度：O(n)。
     * 
     * @param formula
     *            输入一个化学式
     * @return 返回化学式中的各个原子数量
     */
    public String countOfAtoms1(String formula) {
        // 获取字符的长度
        int N = formula.length();
        // stack栈中使用Map集合用于存储原子名称和它对应的数量
        Stack<Map<String, Integer>> stack = new Stack<>();
        // 往栈中添加一个TreeMap，使用TreeMap保证插入元素的顺序性。
        stack.push(new TreeMap<>());
        // 遍历字符串中的字符
        for (int i = 0; i < N;) {
            // 如果formula字符串中遇到(就新建一个TreeMap用于计算()中的原子数量
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap<>());
                i++;
            }
            // 遇到‘)’时结束这个()中TreeMap中的原子数量的计算
            else if (formula.charAt(i) == ')') {
                // 将栈顶的Map集合取出，即为()中的原子集
                Map<String, Integer> top = stack.pop();
                // iStart为()外的第一个数字或者原子， 作用是为了计算()中的原子的数量积。
                int iStart = ++i, multiplicity = 1;
                // 遇到数字将i自增，计算原子数量
                while (i < N && Character.isDigit(formula.charAt(i)))
                    i++;
                if (i > iStart)
                    multiplicity = Integer.parseInt(formula.substring(iStart, i));
                for (String c : top.keySet()) {
                    int v = top.get(c);
                    // 往栈顶的TreeMap中添加()中的原子和对应的原子数量。peek()为看一眼栈顶元素。
                    // 此处栈顶的TreeMap即父()中的TreeMap原子:数量集合。
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
                }
            } else {// 没有遇到‘(’和‘)’ 的情况下，就很简单。
                int iStart = i++;
                while (i < N && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String name = formula.substring(iStart, i);
                // 表示两个或多这个字符组成的原子
                iStart = i;
                while (i < N && Character.isDigit(formula.charAt(i)))
                    i++;
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                // 往栈顶的TreeMap中添加()中的原子和对应的原子数量。peek()为看一眼栈顶元素。
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }
        StringBuilder ans = new StringBuilder();
        // 遍历栈中的Map集合
        for (String name : stack.peek().keySet()) {
            ans.append(name);
            int multiplicity = stack.peek().get(name);
            // 只有当multiplicity大于1的时候才会添加原子的数量
            if (multiplicity > 1)
                ans.append("" + multiplicity);
        }
        return new String(ans);
    }

    public String countOfAtoms2(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();// <atom,occur>
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i < formula.length()) {
            char ch = formula.charAt(i);
            i++;
            if (ch == '(') { // push cur into stack
                stack.push(map);
                map = new HashMap<>();
            } else if (ch == ')') { // pop
                // get number
                int val = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i++) - '0';
                }
                if (val == 0) {
                    val = 1;
                }
                // check put current map to stack
                if (!stack.isEmpty()) {
                    Map<String, Integer> temp = map;
                    map = stack.pop();
                    for (String str : temp.keySet()) {
                        map.put(str, map.getOrDefault(str, 0) + temp.get(str) * val);
                    }
                }
            } else {
                // get atom name
                int start = i - 1;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String str = formula.substring(start, i);
                // get number
                int val = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i++) - '0';
                }
                if (val == 0) {
                    val = 1;
                }
                // put occurance to map
                map.put(str, map.getOrDefault(str, 0) + val);
            }
        }
        // put stack of maps to result string
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String str : list) {
            sb.append(str);
            if (map.get(str) > 1) {
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }
}
