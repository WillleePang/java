package com.willlee.algorithms.quicksort;

public class TriPivotQuickSort {
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

	public TriPivotQuickSort(int max) {
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
		int size = nElems;
		if (size <= 3) {
			manualSort(left, right);
		} else {
			long median = medianOf3(left, right);
			int partition = partition(left, right, median);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	public long medianOf3(int left, int right) {
		int center = (left + right) / 2;

		if (theArray[left] > theArray[center])
			swap(left, center);
		if (theArray[left] > theArray[right])
			swap(left, right);
		if (theArray[center] > theArray[right])
			swap(center, right);
		swap(center, right - 1);
		return theArray[right - 1];
	}

	public void manualSort(int left, int right) {
		int size = nElems;
		if (size <= 1) {
			return;
		} else if (size == 2) {
			if (theArray[left] > theArray[right]) {
				swap(left, right);
			}
			return;
		} else {
			if (theArray[left] > theArray[right - 1])
				swap(left, right - 1);
			if (theArray[left] > theArray[right])
				swap(left, right);
			if (theArray[right - 1] > theArray[right])
				swap(right - 1, right);
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
