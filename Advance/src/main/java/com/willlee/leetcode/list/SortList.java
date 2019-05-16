package com.willlee.leetcode.list;

//leetcode148
public class SortList {
    public static ListNode sortList(ListNode head) {
        return head == null ? null : dichotomia(head);
    }

    private static ListNode dichotomia(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l1 = dichotomia(head);
        ListNode l2 = dichotomia(slow);
        return mergeSort(l1, l2);
    }

    private static ListNode mergeSort(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeSort(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeSort(l2.next, l1);
            return l2;
        }
    }
}
