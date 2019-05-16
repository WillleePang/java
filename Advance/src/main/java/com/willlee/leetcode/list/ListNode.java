package com.willlee.leetcode.list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode pre;
    public ListNode child;
    public ListNode random;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, ListNode next, ListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    public void printList() {
        String s = Integer.toString(this.val);
        ListNode p = next;
        while (p != null) {
            s += "-" + p.val;
            p = p.next;
        }
        System.out.println(s);
    }

    public static ListNode generate(int[] a) {
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
