package com.willlee.leetcode.list;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(-1);
        ListNode l3 = head;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + flag;
            flag = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (flag > 0) {
            l3.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(3);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(2);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        ListNode l2_1 = new ListNode(4);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(5);
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        addTwoNumbers(l1_1, l2_1).printList();
    }
}
