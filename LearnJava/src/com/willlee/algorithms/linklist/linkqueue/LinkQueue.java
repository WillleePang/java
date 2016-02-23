package com.willlee.algorithms.linklist.linkqueue;

public class LinkQueue {
	private FirstLastList list;

	public LinkQueue() {
		list = new FirstLastList();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void insert(long j) {
		list.insertLast(j);
	}

	public long remove() {
		return list.deleteFirst();
	}

	public void displayQueue() {
		System.out.println("Queue (front-->rear): ");
		list.displayList();
	}
}
