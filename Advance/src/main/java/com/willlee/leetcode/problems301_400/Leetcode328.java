package com.willlee.leetcode.problems301_400;

import com.willlee.leetcode.utils.ListNode;

//leetcode328
public class Leetcode328 {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode c = q.next;
        int i = 1;
        while (c != null) {
            if (i % 2 == 1) {
                ListNode n = p.next;
                q.next = c.next;
                p.next = c;
                c.next = n;
                p = p.next;
                c = q.next;
            } else {
                q = q.next;
                c = c.next;
            }
            i++;
        }
        return head;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点
        // o 为奇链表尾节点
        ListNode o = head;
        // p 为偶链表头结点
        ListNode p = head.next;
        // e 为偶链表尾节点
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        int x = 1;

        while (head != null) {
            if (x % 2 != 0) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
                x++;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
                x++;
            }
        }

        node1.next = dummyHead2.next;
        return dummyHead1.next;

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a1.printList();
        System.out.println("=====================");
        a1 = oddEvenList(a1);
        System.out.println("=====================");
        a1.printList();
    }
}
