package com.willlee.algorithms.insertsort;

public class ArrayIns {
	private long[] a;
	private int nElems;

	public ArrayIns(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");

		}
		System.out.println("");
	}

	public void insertSort() {
		int in, out;
		for (out = 1; out < nElems; out++) {
			// 默认第零个数字是排好序的
			long temp = a[out];
			in = out;
			// in之前的所有数字是排好序的，并进行挨个比较，只要比其小，便将数字往后移动一位，空出位置
			while (in > 0 && a[in - 1] >= temp) {
				a[in] = a[in - 1];
				--in;
			}
			//最后将temp中的比较数字，插入到空位置
			a[in] = temp;
		}
	}

	public void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
