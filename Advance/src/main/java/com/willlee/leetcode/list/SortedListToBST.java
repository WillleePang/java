package com.willlee.leetcode.list;

import com.willlee.leetcode.tree.TreeNode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        TreeNode treeNode = new TreeNode(mid.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(mid.next);
        return treeNode;
    }
}
