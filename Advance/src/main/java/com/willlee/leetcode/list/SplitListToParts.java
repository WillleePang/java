package com.willlee.leetcode.list;

//leetcode725
public class SplitListToParts {
	public ListNode[] splitListToParts(ListNode root, int k) {
		int a = 0;
		ListNode p = root;
		while (p != null) {
			a++;
			p = p.next;
		}
		ListNode[] b = new ListNode[k];
		int n = a / k;// 每个链表中有几个元素
		int m = a % k;// 前几个应该+1
		p = root;
		for (int i = 0; i < k & p != null; i++) {
			b[i] = p;
			int o = n + (m-- > 0 ? 1 : 0);
			for (int j = 0; j < o - 1; j++) {
				p = p.next;
			}
			ListNode q = p.next;
			p.next = null;
			p = q;
		}
		return b;
	}
}
