package com.willlee.leetcode.list;

import java.util.HashSet;
import java.util.Set;

public class NumComponents {

	// 记录一下：这个题目还是比较好理解的，遍历一次链表，判断链表节点存储的值是否在数组G中，进行可以计算出组件的个数。
	// 假设链表长度为N，数组G的长度为M，暴力法的时间复杂度为O(N*M)，空间复杂度为O(1)。
	// 可以优化的点在于判断链表节点存储的值是否在于数组G的算法上，题目中写到链表长度最大为10000，可以利用空间换时间，创建一个长度为10000的布尔值类型(占据空间最少)数组A，\]
	// 默认存储值为false,数组G中对应的值对应索引的值为true，这样根据链表节点存储的值判断是否存在于数组G的问题就可以转换为数组A某索引上对应值的问题，时间复杂度由O(M)
	// 优化为 O(1)， 这样本题算法时间复杂度为O(N)，空间复杂度为O(10000)。
	// 后续若有类似的数组判断的问题，条件允许的情况下可以使用类似的空间换时间的方法进行时间复杂度的优化。最后是代码:

	public static int numComponents(ListNode head, int[] G) {
		int num = 0;
		boolean[] A = new boolean[10000];
		for (int i : G) {
			A[i] = true;
		}
		ListNode p = head;
		while (p != null) {
			if (A[p.val]) {
				while (p.next != null && A[p.next.val]) {
					p = p.next;
				}
				num++;
			}
			p = p.next;
		}
		return num;
	}

	public static int numComponents1(ListNode head, int[] G) {
		Set<Integer> set = new HashSet<>();
		for (int num : G) {
			set.add(num);
		}
		int count = 0;
		ListNode pre = head;
		while (head != null) {
			if (set.contains(pre.val) && !set.contains(head.val)) {
				count++;
			}
			pre = head;
			head = head.next;
		}
		if (set.contains(pre.val)) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(0);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(2);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(1);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		int[] a = { 0, 2, 1 };
		int i = numComponents(a1, a);
		System.out.println(i);
	}
}
