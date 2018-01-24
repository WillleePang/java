package com.willlee.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 通过ensureCapacity(int paramInt)方法可以提高ArrayList的初始化速度
 * 
 * @author Administrator
 * 
 */
public class ArrayListTest {

	public static void endureCapacity() {
		int N = 1000000;
		Object object = new Object();

		ArrayList<Object> list = new ArrayList<Object>();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i <= N; i++) {
			list.add(object);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("没有调用ensureCapacity()方法所用时间："
				+ (endTime - startTime) + "ms");

		/* 调用ensureCapacity()方法初始化ArrayList对象 */
		list = new ArrayList<Object>();
		startTime = System.currentTimeMillis();

		// 预先设置list的大小
		list.ensureCapacity(N);
		for (int i = 0; i <= N; i++) {
			list.add(object);
		}
		endTime = System.currentTimeMillis();
		System.out.println("调用ensureCapacity()方法所用时间：" + (endTime - startTime)
				+ "ms");
	}

	public static void ArrayListandLinkedList() {
		long start = System.currentTimeMillis();
		ArrayList<Object> list = new ArrayList<Object>();
		Object obj = new Object();
		for (int i = 0; i < 5000000; i++) {
			list.add(obj);
		}
		long end = System.currentTimeMillis();
		System.out.println("arraylist添加object所用的时间： "+(end - start));

		start = System.currentTimeMillis();
		LinkedList<Object> list1 = new LinkedList<Object>();
		Object obj1 = new Object();
		for (int i = 0; i < 5000000; i++) {
			list1.add(obj1);
		}
		end = System.currentTimeMillis();
		System.out.println("linkedlist添加object所用的时间："+(end - start));

		start = System.currentTimeMillis();
		Object obj2 = new Object();
		for (int i = 0; i < 1000; i++) {
			list.add(0, obj2);
		}
		end = System.currentTimeMillis();
		System.out.println("arraylist表头添加object所用的时间： "+(end - start));

		start = System.currentTimeMillis();
		Object obj3 = new Object();
		for (int i = 0; i < 1000; i++) {
			list1.add(obj3);
		}
		end = System.currentTimeMillis();
		System.out.println("linkedlist表头添加object所用的时间："+(end - start));

		start = System.currentTimeMillis();
		list.remove(0);
		end = System.currentTimeMillis();
		System.out.println("arraylist表头移除object所用的时间： "+(end - start));

		start = System.currentTimeMillis();
		list1.remove(250000);
		end = System.currentTimeMillis();
		System.out.println("linkedlist表头移除object所用的时间："+(end - start));

	}

	public static void main(String[] args) {
		ArrayListandLinkedList();
	}
}
