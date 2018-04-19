package com.willlee.javamultithread;

import java.util.concurrent.CountDownLatch;

public class CountdownLatch {
	public static void main(String[] args) {
		final CountDownLatch c = new CountDownLatch(10);

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				public void run() {
					System.out.println(Thread.currentThread().getId() + " begin");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getId() + " end");
					c.countDown();
				}

			}).start();
		}
		try {
			c.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("10个线程已经执行完毕！开始计算排名");
	}
}
