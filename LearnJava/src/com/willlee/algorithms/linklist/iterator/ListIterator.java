package com.willlee.algorithms.linklist.iterator;

public class ListIterator {
	private Link current;
	private Link previous;
	private LinkList list;

	public ListIterator(LinkList list) {
		this.list = list;
		reset();
	}

	public void reset() {
		current = list.getFirst();
		previous = null;
	}

	public boolean atEnd() {
		return (current.next == null);
	}

	public void nextLink() {
		previous = current;
		current = current.next;
	}

	public Link getCurrent() {
		return current;
	}

	public void insertAfter(long dd) {
		Link link = new Link(dd);
		if (list.isEmpty()) {
			list.setFirst(link);
			current = link;
		} else {
			link.next = current.next;
			current.next = link;
			nextLink();
		}
	}

	public void insertBefore(long dd) {
		Link link = new Link(dd);

		if (previous == null) {
			link.next = list.getFirst();
			list.setFirst(link);
			reset();
		} else {
			link.next = previous.next;
			previous.next = link;
			current = link;
		}
	}
	
	public long deleteCurrent(){
		long value = current.dData;
		if(previous == null){
			list.setFirst(current.next);
			reset();
		}else{
			previous.next = current.next;
			if(atEnd()){
				reset();
			}else{
				current = current.next;
			}
		}
		return value;
	}
}
