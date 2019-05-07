package com.willlee.leetcode.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    void printList() {
        String s = Integer.toString(this.val);
        while (next != null) {
            s += "-" + next.val;
            next = next.next;
        }
        System.out.println(s);
    }
}
