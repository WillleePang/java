package com.willlee.leetcode.problems201_300;

import java.util.Stack;

import com.willlee.leetcode.utils.ListNode;

//leetcode234
public class Leetcode234 {
	// 快慢指针，前半部用栈，跟后半部分循环对比
	public static boolean isPalindrome1(ListNode head) {
		Stack<Integer> stack = new Stack<Integer>();
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null)
			slow = slow.next;
		int n = stack.size();
		for (int i = 0; i < n; i++) {
			if (stack.pop() != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
	}

	// hash
	public static boolean isPalindrome2(ListNode head) {
		int lhash = 0, rhash = 0;
		for (int x = 1; head != null; head = head.next, x *= 11) {
			lhash = lhash * 11 + head.val;
			rhash = rhash + head.val * x;
		}
		return lhash == rhash;
	}

	// 递归回溯
	static ListNode h;

	public static boolean isPalindrome3(ListNode head) {
		if (head == null)
			return true;
		if (h == null)
			h = head;
		boolean temp = true;
		if (head.next != null)
			temp &= isPalindrome3(head.next);
		temp &= (head.val == h.val);
		h = h.next;
		return temp;
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(3);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(2);
		ListNode a4 = new ListNode(1);
		ListNode a5 = new ListNode(2);
		ListNode a6 = new ListNode(4);
		ListNode a7 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = a7;
		a1.printList();
		System.out.println(isPalindrome2(a1));
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(0);
		ListNode b3 = new ListNode(1);
		b1.next = b2;
		b2.next = b3;
		b1.printList();
		System.out.println(isPalindrome1(b1));
	}
}