package com.willlee.javamultithread;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicIntegerTest {
	public static void main(String[] args) {
		AtomicInteger i = new AtomicInteger();
		i.addAndGet(1);
		i.getAndIncrement();
		i.decrementAndGet();		
	}
}
