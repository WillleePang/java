package com.willlee.leetcode.list;

//leetcode82,83 
public class DeleteDuplicates {
	public static ListNode deleteDuplicates1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode new_head = new ListNode(head.val);
		ListNode p = new_head;
		head = head.next;
		while (head != null) {
			if (head.val == p.val) {
				head = head.next;
				continue;
			} else {
				p.next = new ListNode(head.val);
				p = p.next;
				head = head.next;
			}
		}
		new_head.printList();
		return new_head;
	}

	public static ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode a = new ListNode(0);
		ListNode tail = a;

		while (head != null) {
			int size = 0;
			int temp = head.val;
			while (head.next != null && temp == head.next.val) {
				head = head.next;
				size++;
			}
			if (size == 0) {
				tail.next = new ListNode(head.val);
				tail = tail.next;
			}
			head = head.next;
		}
		return a.next;
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(3);
		ListNode a5 = new ListNode(4);
		ListNode a6 = new ListNode(4);
		ListNode a7 = new ListNode(8);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a1.printList();
		a1 = deleteDuplicates2(a1);
		a1.printList();
	}
}
