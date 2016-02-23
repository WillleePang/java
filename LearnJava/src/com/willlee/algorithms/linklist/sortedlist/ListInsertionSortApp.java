package com.willlee.algorithms.linklist.sortedlist;

import com.willlee.algorithms.linklist.linkstack.Link;

public class ListInsertionSortApp {
	public static void main(String[] args) {
		int size = 10;
		Link[] linkArray = new Link[size];
		for (int j = 0; j < size; j++) {
			int n = (int) (java.lang.Math.random() * 99);
			Link newlink = new Link(n);
			linkArray[j] = newlink;
		}
		System.out.print("Unsorted array: ");
		for (int j = 0; j < size; j++) {
			System.out.print(linkArray[j].dData + " ");
		}
		System.out.println("");

		SortedList list = new SortedList(linkArray);
		for (int j = 0; j < size; j++) {
			linkArray[j] = list.remove();
		}
		System.out.print("Sorted Array: ");
		for (int j = 0; j < size; j++) {
			System.out.print(linkArray[j].dData + " ");
		}
		System.out.println("");
	}
}
