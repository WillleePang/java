package com.willlee.leetcode.list;

import java.util.Stack;

//leetcode143
public class ReorderList {
    
    //用stack就是慢
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode begin = slow.next;
        slow.next = null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (begin != null) {
            stack.push(begin);
            begin = begin.next;
        }
        slow = head;
        while (!stack.isEmpty()) {
            fast = stack.pop();
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
        }
    }

    public static void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        slow = head;
        while (slow != null && fast != null) {
            ListNode p = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = p;
        }
    }

    static ListNode reverse(ListNode head) {
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = p2;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
        ListNode head = ListNode.generate(a);
        head.printList();
        reorderList1(head);
        head.printList();
    }
}
