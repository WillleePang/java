package com.willlee.leetcode.list;

public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        } else {
            ListNode fast = head;
            ListNode slow = head;
            int fastIndex = 0;
            while (fastIndex < k) {
                fast = fast.next;
                fastIndex++;
            }
            int slowIndex = 0;
            while (slowIndex < (length - (fastIndex + 1))) {
                fast = fast.next;
                slow = slow.next;
                slowIndex++;
            }
            ListNode new_head = slow.next;
            slow.next = null;
            fast.next = head;
            head = new_head;
            return head;
        }
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
        a1 = rotateRight(a1, 2);
        a1.printList();
    }
}
