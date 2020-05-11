package com.willlee.leetcode.problems201_300;

import com.willlee.leetcode.utils.ListNode;

//leetcode237
public class Leetcode237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
