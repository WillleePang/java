package com.willlee.leetcode.problems1_100;

import com.willlee.leetcode.utils.ListNode;

//leetcode86
public class Leetcode86 {
	public static ListNode partition(ListNode head, int x) {
		ListNode h1 = new ListNode(0);
		ListNode h2 = new ListNode(0);
		ListNode p1 = h1;
		ListNode p2 = h2;
		while (head != null) {
			if (head.val < x) {
				p1.next = new ListNode(head.val);
				p1 = p1.next;
			} else {
				p2.next = new ListNode(head.val);
				p2 = p2.next;
			}
			head = head.next;
		}
		p1.next = h2.next;
		return h1.next;
	}

	public static ListNode partition1(ListNode head, int x) {
		ListNode head1 = new ListNode(0);
		head1.next = head;
		ListNode pre = head1;
		ListNode firstBig = null;
		ListNode preFirstBig = null;
		while (head != null) {
			if (head.val >= x) {
				if (firstBig == null) {
					firstBig = head;
					preFirstBig = pre;
				}
			} else {
				if (firstBig != null) {
					ListNode temp = head;
					pre.next = head.next;
					preFirstBig.next = head;
					head.next = firstBig;
					preFirstBig = preFirstBig.next;
					head = temp;
				}
			}
			pre = head;
			head = head.next;
		}
		return head1.next;
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(3);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(2);
		ListNode a4 = new ListNode(1);
		ListNode a5 = new ListNode(10);
		ListNode a6 = new ListNode(0);
		ListNode a7 = new ListNode(21);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a1.printList();
		a1 = partition1(a1, 2);
		a1.printList();
	}
}
