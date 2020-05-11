package com.willlee.leetcode.problems201_300;

import com.willlee.leetcode.utils.ListNode;

public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
