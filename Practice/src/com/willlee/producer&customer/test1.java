/*
* @Author: hq
* @Date:   2016-11-14 16:53:30
* @Last Modified by:   hq
* @Last Modified time: 2016-11-15 11:14:13
*/

package com.willlee.producer&customer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test1 {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putIndex, takeIndex, count;

	public void put(Object object) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length) {
				notFull.await();
			}
			items[putIndex] = object;
			if (++putIndex == items.length) {
				putIndex = 0;
			}
			count++;
			notEmpty.signal();
		} catch (Exception e) {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) {
				notEmpty.await();
			}
			Object object = items[takeIndex];
			if(++takeIndex == items.length){
				takeIndex = 0;
			}
			count--;
			notFull.signal();
			return object;
		} catch (Exception e) {
			lock.unlock();
		}
		return null;
	}
}
