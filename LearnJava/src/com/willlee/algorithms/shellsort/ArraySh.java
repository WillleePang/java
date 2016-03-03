package com.willlee.algorithms.shellsort;

public class ArraySh {
	private long[] theArray;
	private int nElems;

	public ArraySh(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public void display() {
		System.out.print("A=");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
			if (i % 100 == 0&&i!=0) {
				System.out.println("");
			}
		}
		System.out.println("");
	}

	public void shellSort() {
		int inner, outer;
		long temp;

		int h = 1;
		while (h < nElems / 3) {
			h = h * 3 + 1;
		}
		// 判断h距离是否到1
		while (h > 0) {
			// 从h开始循环，则为此次排序的，这里的数字是内循环中的排序数组的最后一个数字
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;
				// 对之前的所有h间隔的数字进行插入排序
				while (inner >= h && theArray[inner - 1] > temp) {
					theArray[inner] = theArray[inner - h];
					inner = inner - h;
				}
				theArray[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
}
