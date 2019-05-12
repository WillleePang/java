package com.willlee.leetcode.list;

//leetcode707
public class MyLinkedList {
	private static class Node {
		int val;
		Node next;

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	private Node head;
	private int size;

	/** Initialize your data structure here. */
	public MyLinkedList() {

	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (index >= this.size || index < 0)
			return -1;
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node temp = new Node(val, this.head);
		this.head = temp;
		this.size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (this.size == 0)
			head = new Node(val, null);
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(val, null);
		}
		this.size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index > this.size)
			return;
		if (index < 0)
			addAtHead(val);
		if (index == 0)
			addAtHead(val);
		else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			Node newNode = new Node(val, temp.next);
			temp.next = newNode;
			this.size++;
		}

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index >= this.size || index < 0)
			return;
		if (index == 0)
			head = head.next;
		else {
			Node temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		this.size--;
	}
}
