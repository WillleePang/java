package com.willlee.leetcode.list;

import java.util.Stack;

//leetcode2 445
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(-1);
        ListNode l3 = head;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + flag;
            flag = sum / 10;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (flag > 0) {
            l3.next = new ListNode(1);
        }
        return head.next;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 用栈反转链表
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        int max = Math.max(s1.size(), s2.size());
        for (int i = 0; i < max; i++) {
            int a = s1.empty() ? 0 : s1.pop();
            int b = s2.empty() ? 0 : s2.pop();
            int sum = a + b + carry;
            System.out.println(sum);
            carry = sum / 10 == 1 ? 1 : 0;
            int remainder = sum % 10;
            s3.push(remainder);
        }
        if (carry != 0) {
            s3.push(carry);
        }
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int size = s3.size();
        for (int i = 0; i < size; i++) {
            p.next = new ListNode(s3.pop());
            p = p.next;
        }
        return head.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int m = 0;
        while (p != null) {
            p = p.next;
            m++;
        }
        int n = 0;
        while (q != null) {
            q = q.next;
            n++;
        }
        p = l1;
        q = l2;
        ListNode[] a1 = new ListNode[m];
        ListNode[] b1 = new ListNode[n];
        m--;
        n--;
        while (p != null) {
            a1[m--] = p;
            p = p.next;
        }
        while (q != null) {
            b1[n--] = q;
            q = q.next;
        }
        ListNode head = new ListNode(-1);
        int carry = 0;
        m = 0;
        n = 0;
        while (m < a1.length || n < b1.length) {
            int a = 0;
            if (m < a1.length) {
                a = a1[m].val;
                m++;
            }
            int b = 0;
            if (n < b1.length) {
                b = b1[n].val;
                n++;
            }
            int sum = a + b + carry;
            System.out.println(sum);
            carry = sum / 10 == 1 ? 1 : 0;
            int remainder = sum % 10;
            ListNode next = head.next;
            head.next = new ListNode(remainder);
            head.next.next = next;
        }
        if (carry != 0) {
            ListNode next = head.next;
            head.next = new ListNode(carry);
            head.next.next = next;
        }
        return head.next;
    }

    public ListNode addTwoNumber3(ListNode l1, ListNode l2) {
        int i1 = 0;
        int i2 = 0;
        ListNode l3 = l1;
        ListNode l4 = l2;
        while (l3 != null) {
            i1++;
            l3 = l3.next;
        }
        while (l4 != null) {
            i2++;
            l4 = l4.next;
        }
        int[] a = new int[i1 > i2 ? i1 + 1 : i2 + 1];
        int n = i1 - 1;
        while (l1 != null) {
            a[n] += l1.val;
            l1 = l1.next;
            n--;
        }
        n = i2 - 1;
        while (l2 != null) {
            a[n] += l2.val;
            l2 = l2.next;
            n--;
        }
        int y = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] += y;
            y = 0;
            if (a[i] > 9) {
                a[i] -= 10;
                y = 1;
            }
        }
        if (a[a.length - 1] == 0) {
            ListNode w = new ListNode(0);
            ListNode e = w;
            for (int i = a.length - 2; i > -1; i--) {
                ListNode s = new ListNode(a[i]);
                w.next = s;
                w = s;
            }
            return e.next;
        } else {
            ListNode w = new ListNode(0);
            ListNode e = w;
            for (int i = a.length - 1; i > -1; i--) {
                ListNode s = new ListNode(a[i]);
                w.next = s;
                w = s;
            }
            return e.next;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(5);
        b1.next = b2;
        b2.next = b3;
        ListNode addTwoNumbers1 = addTwoNumbers2(a1, b1);
        addTwoNumbers1.printList();
    }
}
