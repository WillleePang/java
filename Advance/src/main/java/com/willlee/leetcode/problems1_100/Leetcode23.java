package com.willlee.leetcode.problems1_100;

import com.willlee.leetcode.utils.ListNode;

public class Leetcode23 {
    // 常规解法，很耗时
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length - 1;
        int index = 0;
        while (index <= n) {
            if (index != 0) {
                lists[0] = mergeTwoLists(lists[0], lists[index]);
            }
            index++;
        }
        return lists[0];
    }

    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int n = lists.length - 1;
        return merge(lists, 0, n);
    }

    private static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    // 合并两个有序数组
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode l3 = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if (l1 != null) {
            l3.next = l1;
        } else {
            l3.next = l2;
        }
        return head;
    }

    // [[1,4,5],[1,3,4],[2,6]]
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        ListNode d1 = new ListNode(7);
        ListNode d2 = new ListNode(10);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        c1.next = c2;
        d1.next = d2;
        ListNode[] lists = new ListNode[] { a1, b1, c1, d1 };
        ListNode mergeKLists = mergeKLists(lists);
        mergeKLists.printList();
    }
}
