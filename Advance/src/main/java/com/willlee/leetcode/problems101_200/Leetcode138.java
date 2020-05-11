package com.willlee.leetcode.problems101_200;

import java.util.HashMap;
import java.util.Map;

import com.willlee.leetcode.utils.ListNode;

public class Leetcode138 {
    public ListNode copyRandomList1(ListNode head) {
        if (head == null) {
            return head;
        }
        // map方法，空间复杂度O(n)
        ListNode node = head;
        // 使用hash表存储旧结点和新结点的映射
        Map<ListNode, ListNode> map = new HashMap<>();
        while (node != null) {
            ListNode clone = new ListNode(node.val);
            map.put(node, clone);
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    public ListNode copyRandomList2(ListNode head) {
        if (head == null) {
            return head;
        }
        // 空间复杂度O(1)，将克隆结点放在原结点后面
        ListNode node = head;
        // 1->2->3 ==> 1->1'->2->2'->3->3'
        while (node != null) {
            ListNode clone = new ListNode(node.val, node.next, null);
            ListNode temp = node.next;
            node.next = clone;
            node = temp;
        }
        // 处理random指针
        node = head;
        while (node != null) {
            // ！！
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 还原原始链表，即分离原链表和克隆链表
        node = head;
        ListNode cloneHead = head.next;
        while (node.next != null) {
            ListNode temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }
}
