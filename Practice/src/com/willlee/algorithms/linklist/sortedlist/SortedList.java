package com.willlee.algorithms.linklist.sortedlist;

import com.willlee.algorithms.linklist.linkstack.Link;

public class SortedList {
	private Link first;

	public SortedList() {
		first = null;
	}

	public SortedList(Link[] linkArr) {
		first = null;
		for (int j = 0; j < linkArr.length; j++) {
			insert(linkArr[j]);
		}
	}

	public void insert(Link k) {
		Link previous = null;
		Link current = first;
		while (current != null && k.dData > current.dData) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			first = k;
		} else {
			previous.next = k;
		}
		k.next = current;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insert(long key) {
		Link newLink = new Link(key);
		Link previous = null;
		Link current = first;
		while (current != null && key > current.dData) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			first = newLink;
		} else {
			previous.next = newLink;
		}
		newLink.next = current;
	}

	public Link remove() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	public void displayList() {
		System.out.println("List (first--last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}
