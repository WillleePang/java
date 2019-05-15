package com.willlee.leetcode.list;

//leetcode160
public class GetIntersectionNode {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode p = headA;
		ListNode q = headB;
		while (p != q) {
			p = p == null ? headB : p.next;
			q = q == null ? headA : q.next;
		}
		return p;
	}
}
