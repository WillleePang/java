package com.willlee.leetcode.problems1_100;

import com.willlee.leetcode.utils.ListNode;

public class Leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode insert_head = new ListNode(0);
        ListNode forever_head = insert_head;
        ListNode start = new ListNode(0);
        ListNode end = new ListNode(0);
        while (head != null) {
            int count = 0;
            start = head;
            end = start;
            while (end != null && count < k) {
                end = end.next;
                count++;
            }
            if (count == k) {
                insert_head.next = head;
                head = head.next;
                for (int i = 1; i < k; i++) {
                    ListNode tmp = insert_head.next;
                    insert_head.next = head;
                    head = head.next;
                    insert_head.next.next = tmp;
                }
                start.next = null;
                insert_head = start;

            } else {
                insert_head.next = start;
                break;
            }

        }
        return forever_head.next;
    }
}
