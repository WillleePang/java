package com.willlee.leetcode.list;

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            ListNode cur1 = cur.next;
            cur.next = next;
            cur1.next = cur;
            if (pre == cur) {
                head = cur1;
            } else {
                pre.next = cur1;
            }
            pre = cur;
            cur = next;
        }
        return head;
    }

    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(1);
        ListNode a5 = new ListNode(10);
        ListNode a6 = new ListNode(20);
        ListNode a7 = new ListNode(21);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a1.printList();
        a1 = swapPairs(a1);
        a1.printList();
        a1 = swapPairs1(a1);
        a1.printList();
    }
}
