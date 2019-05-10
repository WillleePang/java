package com.willlee.algo.linkedlist;

import java.util.HashMap;

public class LinkedListAlgo {
    // 单链表反转
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            curr = pre;
            curr = next;
        }
        return pre;
    }

    // 检测环 快慢指针
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }
        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 环检测 足迹法
    // 保存足迹信息 效率太差了，数据量大的时候不能使用
    private static HashMap<Node, Integer> nodeMap = new HashMap<>();

    /**
     * 判断是否有环 足迹法
     * 
     * @param node
     * @return
     */
    public static boolean hasLoopV2(Node node, int index) {
        if (node == null || node.next == null) {
            return false;
        }

        if (nodeMap.containsKey(node)) {
            return true;
        } else {
            nodeMap.put(node, index);
            return hasLoopV2(node.next, ++index);
        }
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null)
            return lb;
        if (lb == null)
            return la;
        Node p = la;
        Node q = lb;

        Node head;

        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;
        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKNode(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null)
            return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间节点
    public static Node findMiddeNode(Node list) {
        if (list == null) {
            return null;
        }
        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {

            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
