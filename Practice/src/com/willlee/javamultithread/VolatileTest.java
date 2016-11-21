package com.willlee.javamultithread;


public class VolatileTest {
	public static volatile int i = 0;

	public static void main(String args[]) {
		new Thread(new Runnable() {
			public void run() {
				for (int j = 0; j < 10000; j++)
					i++;
				System.out.println("Thread1 end...");
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				for (int j = 0; j < 10000; j++)
					i++;
				System.out.println("Thread2 end...");
			}
		}).start();
		i++;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("i = " + i);
	}
}
