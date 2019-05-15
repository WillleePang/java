package com.willlee.leetcode.list;

//leetcode203
public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = next;
                cur = null;
            }
            if (next == null) {
                break;
            } else {
                if (cur != null) {
                    pre = cur;
                }
                cur = next;
                next = next.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[] { 1, 1 });
        head = removeElements(head, 1);
        if (head == null) {
            System.out.println(head);
        } else {
            head.printList();
        }
    }
}
