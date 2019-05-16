package com.willlee.leetcode.list;

//leetcode147
public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = head;
        while (p.next != null) {
            if (p.val > p.next.val) {
                ListNode q = p.next;
                p.next = q.next;
                ListNode pre = dummyHead;
                while (pre.next.val < q.val) {
                    pre = pre.next;
                }
                q.next = pre.next;
                pre.next = q;
            } else {
                p = p.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.generate(new int[] { 0, 11, 12, 4, 7, 3, 4, 99, 0 });
        a.printList();
        a = insertionSortList(a);
        a.printList();
    }
}
