package com.willlee.leetcode.list;

public class ListNode {
    int val;
    ListNode next;
    ListNode pre;
    ListNode child;
    ListNode random;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
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

    static ListNode generate(int[] a) {
        ListNode head = new ListNode(-1);
        ListNode pre = null;
        ListNode cur = null;
        for (int i = 0; i < a.length; i++) {
            cur = new ListNode(a[i]);
            if (i == 0) {
                head.next = cur;
            } else {
                pre.next = cur;
            }
            pre = cur;
        }
        return head.next;
    }
}
