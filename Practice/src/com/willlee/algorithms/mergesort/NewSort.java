package com.willlee.algorithms.mergesort;

public class NewSort {

	public static void main(String[] args) {
		int maxSize = 100;
		NewSort array;
		array = new NewSort(maxSize);
		
		array.insert(64);
		array.insert(21);
		array.insert(70);
		array.insert(33);
		array.insert(12);
		array.insert(44);
		array.insert(85);
		array.insert(0);
		array.insert(3);
		
		array.display();
		array.mergeSort();
		array.display();
	}
	
	private long[] array;
	private int nElems;

	public NewSort(int max) {
		array = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		array[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}

	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {// if range is 1,no use sorting
			return;
		} else {
			int mid = (lowerBound + upperBound) / 2;// find midpoint
			recMergeSort(workSpace, lowerBound, mid);// sort low half
			recMergeSort(workSpace, mid + 1, upperBound);// sort high half
			merge(workSpace, lowerBound, mid + 1, upperBound);// merge them
		}
	}

	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;

		while (lowPtr <= mid && highPtr <= upperBound) {
			if (array[lowPtr] < array[highPtr]) {
				workSpace[j++] = array[lowPtr++];
			} else {
				workSpace[j++] = array[highPtr++];
			}
		}

		while (lowPtr <= mid) {
			workSpace[j++] = array[lowPtr++];
		}
		while (highPtr <= upperBound) {
			workSpace[j++] = array[highPtr++];
		}

		for (j = 0; j < n; j++) {
			array[lowerBound + j] = workSpace[j];
		}
	}
}
