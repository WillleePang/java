package com.willlee.leetcode.list;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
        }
        slow = head;// slow back to start point
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // when slow == fast, it is where cycle begins
    }
}
