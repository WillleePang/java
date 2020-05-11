package com.willlee.leetcode.problems1_100;

import com.willlee.leetcode.utils.ListNode;

//leetcode92
public class Leetcode92 {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode head1 = new ListNode(-1);
		head1.next = head;
		ListNode pre = head1;
		int i = 1;
		while (head != null) {
			if (i >= m && i < n) {
				ListNode temp = head.next;
				head.next = temp.next;
				temp.next = pre.next;
				pre.next = temp;
			} else {
				pre = head;
				head = head.next;
			}
			i++;
		}
		return head1.next;
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a1.printList();
		a1 = reverseBetween(a1, 1, 5);
		a1.printList();
	}
}
