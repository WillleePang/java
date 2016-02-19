package com.willlee.algorithms.linklist.singly;

public class LinkList {
	private Link first;

	public LinkList() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}

	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);// make new link
		newLink.next = first;// it points to old first link
		first = newLink;// now first points to this
	}

	public Link find(int key) {
		Link current = first;// start at "first"
		while (current.iData != key) {// while no match
			if (current.next == null) {// if end of list
				return null;// didn't find it
			} else { // not end of list
				current = current.next;// go to next link
			}
		}
		return current;// found it
	}

	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while (current.iData != key) {
			if (current.next == null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}

	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

}
