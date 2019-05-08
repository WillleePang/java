package com.willlee.leetcode.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    void printList() {
        String s = Integer.toString(this.val);
        ListNode p = next;
        while (p != null) {
            s += "-" + p.val;
            p = p.next;
        }
        System.out.println(s);
    }
}
