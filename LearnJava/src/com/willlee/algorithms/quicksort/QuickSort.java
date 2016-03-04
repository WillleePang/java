package com.willlee.algorithms.quicksort;

public class QuickSort {

	public static void main(String[] args) {
		int maxSize = 16;
		QuickSort arr;
		arr = new QuickSort(maxSize);

		for (int j = 0; j < maxSize; j++) {
			long n = (int) (java.lang.Math.random() * 199);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
	}

	private long[] theArray;
	private int nElems;

	public QuickSort(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public void display() {
		System.out.print("A=");
		for (int j = 0; j < nElems; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println("");
	}

	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

	public void recQuickSort(int left, int right) {
		if (right <= left) {
			return;
		} else {
			long pivot = theArray[right];

			int partition = partition(left, right, pivot);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	// left是数组的第一个数字index，right是数组的最后一个数字index
	public int partition(int left, int right, long pivot) {
		int leftPtr = left - 1;// right of first elem
		int rightPtr = right + 1;// left of pivot
		while (true) {
			// find bigger item
			while (leftPtr < right && theArray[++leftPtr] < pivot) {
				;
			}
			// find smaller item
			while (rightPtr > left && theArray[--rightPtr] > pivot) {
				;
			}
			if (leftPtr >= rightPtr) {// if pointers cross, partition done
				break;
			} else { // not crossed ,so swap elements
				swap(leftPtr, rightPtr);
			}
		}
		return leftPtr;
	}

	public void swap(int dex1, int dex2) {
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}
