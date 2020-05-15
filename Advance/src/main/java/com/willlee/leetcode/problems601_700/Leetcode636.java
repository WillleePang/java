package com.willlee.leetcode.problems601_700;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode636 {

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        Leetcode636 a = new Leetcode636();
        a.exclusiveTime(n, logs);
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            //
            if (!stack.isEmpty()) {
                res[stack.peek()] += Integer.parseInt(parts[2]) - prevTime;
            }
            // 记录上次的时间
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) {
                stack.push(Integer.parseInt(parts[0]));
            } else {
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }
}
