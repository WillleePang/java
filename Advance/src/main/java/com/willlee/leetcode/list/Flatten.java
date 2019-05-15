package com.willlee.leetcode.list;

//leetcode430
public class Flatten {
    public static ListNode flatten(ListNode head) {
        if (head == null) {
            return null;
        }
        haha(head);
        return head;
    }

    static ListNode haha(ListNode head) {
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null && next != null) {
            if (cur.child != null) {
                cur.next = cur.child;
                cur.child.pre = cur;
                cur.child = null;
                cur = haha(cur.next);
                cur.next = next;
                next.pre = cur;
            }
            cur = cur.next;
            next = next.next;
        }
        if (cur.child != null) {
            cur.next = cur.child;
            cur.child.pre = cur;
            cur.child = null;
            cur = haha(cur.next);
        }
        return cur;
    }

    /**
     * 每次调整完返回的值是当前那一行的最后一个节点 上一层拿到下一行节点的最后一个就可以操作了
     * 
     * @param head
     * @return
     */
    static ListNode fun(ListNode head) {
        ListNode cur = head; // 主要的操作指针
        ListNode next = cur.next; // 后一个节点的指针，用来标记
        while (true) { // 一直循环，到条件了跳出来
            if (next == null) { // 如果前驱指针已经走到最后
                if (cur.child != null) { // 要注意主操作节点下面是否有子指针，有的话要调整的
                    cur.next = cur.child;
                    cur.child.pre = cur;
                    cur.child = null;
                    cur = fun(cur.next);
                }
                break; // 调整完了或者主操作节点下面没有子指针，跳出循环
            }
            if (cur.child != null) { // 如果当前主操作节点下面有子指针，调整
                cur.next = cur.child;
                cur.child.pre = cur;
                cur.child = null;
                cur = fun(cur.next); // 获取下一层的链表的最后一个节点
                cur.next = next; // 下一层链表的最后一个节点的下一个节点就是当前链表的前驱节点
                next.pre = cur; // 当前链表的前驱节点的前驱就是下一层链表的最后一个节点
            }
            cur = cur.next; // 移动这两个指针
            next = next.next;
        }
        return cur; // 操作完成后，跳出循环来到这，一定走到了当前链表的最后一个节点，返回它，以供上层调用者使用
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.pre = a1;
        a2.next = a3;
        a3.pre = a2;
        a3.next = a4;
        a4.pre = a3;
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(2);
        a2.child = b1;
        b1.next = b2;
        b2.pre = b1;
        b2.next = b3;
        b3.pre = b2;
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(3);
        b3.child = c1;
        c1.next = c2;
        c2.pre = c1;
        flatten(a1);
        a1.printList();
    }
}
