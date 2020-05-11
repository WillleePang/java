package com.willlee.leetcode.problems801_900;

import com.willlee.leetcode.utils.ListNode;

public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }
}
