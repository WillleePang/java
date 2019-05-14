package com.willlee.leetcode.list;

//leetcode237
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
