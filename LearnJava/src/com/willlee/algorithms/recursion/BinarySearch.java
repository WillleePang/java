package com.willlee.algorithms.recursion;

public class BinarySearch {

	public static void main(String[] args) {
		int maxSize = 100;
		BinarySearch arr;
		arr = new BinarySearch(maxSize);
		arr.insert(72);
		arr.insert(90);
		arr.insert(126);
		arr.insert(354);
		arr.insert(399);
		arr.insert(144);
		arr.insert(135);
		arr.insert(9);
		arr.insert(117);
		arr.display();

		int searchKey = 9;
		if (arr.find(searchKey) != arr.size()) {
			System.out.println("Found " + searchKey);
		} else {
			System.out.println("Can't find " + searchKey);
		}
	}

	private long[] a;
	private int nElems;

	public BinarySearch(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] > value)
				break;
		}
		for (int k = nElems; k > j; k--) {
			a[k] = a[k - 1];
		}
		a[j] = value;
		nElems++;
	}

	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();
	}

	public int find(long searchKey) {
		return recFind(searchKey, 0, nElems - 1);
	}

	private int recFind(long searchKey, int lowerBound, int upperBound) {
		int curIn;
		curIn = (lowerBound + upperBound) / 2;
		if (a[curIn] == searchKey) {
			return curIn;
		} else if (lowerBound > upperBound) {
			return nElems;
		} else {
			if (a[curIn] < searchKey) {
				return recFind(searchKey, curIn + 1, upperBound);
			} else {
				return recFind(searchKey, lowerBound, curIn - 1);
			}
		}
	}

}
