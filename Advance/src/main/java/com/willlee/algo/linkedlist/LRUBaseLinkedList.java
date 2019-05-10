package com.willlee.algo.linkedlist;

import java.util.Scanner;

// 基于单链表LRU算法
@SuppressWarnings({ "rawtypes", "hiding", "unchecked", "unused", "resource" })
public class LRUBaseLinkedList<T> {
    private final static Integer DEFAULT_CAPACITY = 10;
    private SNode<T> headNode;
    private Integer length;
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findPreNode(data);
        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            intsertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                // 删除尾结点
                deleteElemAtEnd();
            }
            intsertElemAtBegin(data);
        }
    }

    private void intsertElemAtBegin(T data) {
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    // 删除preNode结点下一个元素
    private void deleteElemOptim(SNode preNode) {
        SNode currentNode = preNode.getNext();
        preNode.setNext(currentNode.getNext());
        currentNode = null;
        length--;
    }

    // 删除尾节点
    private void deleteElemAtEnd() {
        SNode node = headNode;
        if (node.getNext() == null) {
            return;
        }
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        SNode endNode = node.getNext();
        node.setNext(null);
        endNode = null;
        length--;
    }

    // 找到前置节点
    private SNode findPreNode(T data) {
        SNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void printAll() {
        SNode next = headNode.getNext();
        while (next != null) {
            System.out.println(next.getElement() + ",");
            next = next.getNext();
        }
        System.out.println();
    }

    public class SNode<T> {
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
