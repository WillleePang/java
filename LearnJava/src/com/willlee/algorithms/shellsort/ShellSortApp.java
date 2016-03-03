package com.willlee.algorithms.shellsort;

public class ShellSortApp {
	public static void main(String[] args) {
		int maxSize = 10000;
		ArraySh arr;
		arr = new ArraySh(maxSize);

		for (int j = 0; j < maxSize; j++) {
			long n = (int) (java.lang.Math.random() * 999999);
			arr.insert(n);
		}
		arr.display();
		long start = System.currentTimeMillis();
		arr.shellSort();
		long end = System.currentTimeMillis();
		System.out.println("use time is :" + (end - start));
		arr.display();
	}
}
