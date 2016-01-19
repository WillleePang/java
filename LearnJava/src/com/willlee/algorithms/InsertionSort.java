package com.willlee.algorithms;

public class InsertionSort {

	private int[] sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			//将空余的地方补上key，因为key大于前面的数，小于后面的数
			arr[j+1] = key;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 5, 10, 56, 4, 7, 9 };
		InsertionSort insert = new InsertionSort();
		insert.sort(array);
		for(int i : array){
			System.out.print(i+" ");
		}
	}
}
