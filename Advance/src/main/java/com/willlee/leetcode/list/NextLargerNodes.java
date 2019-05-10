package com.willlee.leetcode.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextLargerNodes {
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
                res[stack.pop()] = list.get(i);
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(9999);
        ListNode b1 = a1;
        for (int j = 9998; j > 0; j--) {
            a1.next = new ListNode(j);
            a1 = a1.next;
        }
        b1.printList();
        int[] nextLargerNodes = nextLargerNodes(b1);
        for (int i = 0; i < nextLargerNodes.length; i++) {
            if (i == nextLargerNodes.length - 1) {
                System.out.print(nextLargerNodes[i] + "");
            } else {
                System.out.print(nextLargerNodes[i] + "-");
            }
        }
    }
}