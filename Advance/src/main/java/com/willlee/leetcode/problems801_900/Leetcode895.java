package com.willlee.leetcode.problems801_900;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode895 {
    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class FreqStack {
    private Map<Integer, Integer> keyCountMap;
    private Map<Integer, Stack<Integer>> countKeyStackMap;
    private int maxCount;

    public FreqStack() {
        keyCountMap = new HashMap<>();
        countKeyStackMap = new HashMap<>();
        maxCount = 0;
    }

    public void push(int x) {
        //获取x的数量
        Integer count = keyCountMap.get(x);
        if (count == null) {
            count = 0;
        }
        ++count;
        keyCountMap.put(x, count);
        
        //count下的stack
        Stack<Integer> stack = countKeyStackMap.get(count);
        if (stack == null) {
            stack = new Stack<Integer>();
        }
        stack.push(x);
        countKeyStackMap.put(count, stack);
        
        maxCount = Math.max(maxCount, count);
    }

    public int pop() {
        Stack<Integer> stack = countKeyStackMap.get(maxCount);
        Integer key = stack.pop();

        if (stack.size() == 0) {
            --maxCount;
        }

        Integer count = keyCountMap.get(key);
        keyCountMap.put(key, --count);

        return key;
    }
}