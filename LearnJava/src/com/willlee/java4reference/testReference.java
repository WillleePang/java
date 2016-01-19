package com.willlee.java4reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class testReference {

	private static ReferenceQueue<Grocery> rq = new ReferenceQueue<Grocery>();

	public static void checkQueue() {
		Reference<? extends Grocery> inq = rq.poll();
		if (inq != null) {
			System.out.println("In queue : " + inq.get());
		}
	}

	public static void test3Reference() {
		final int size = 10;
		Set<SoftReference<Grocery>> sa = new HashSet<SoftReference<Grocery>>();

		for (int i = 0; i < size; i++) {
			SoftReference<Grocery> ref = new SoftReference<Grocery>(
					new Grocery("Soft " + i), rq);
			System.out.println("Just created: " + ref.get());
			sa.add(ref);
		}

		System.gc();
		checkQueue();

		Set<WeakReference<Grocery>> wa = new HashSet<WeakReference<Grocery>>();

		for (int i = 0; i < size; i++) {
			WeakReference<Grocery> ref = new WeakReference<Grocery>(
					new Grocery("Weak " + i), rq);
			System.out.println("Just created: " + ref.get());
			wa.add(ref);
		}

		System.gc();
		checkQueue();

		Set<PhantomReference<Grocery>> pa = new HashSet<PhantomReference<Grocery>>();

		for (int i = 0; i < size; i++) {
			PhantomReference<Grocery> ref = new PhantomReference<Grocery>(
					new Grocery("Phantom " + i), rq);
			System.out.println("Just created: " + ref.get());
			pa.add(ref);
		}

		System.gc();
		checkQueue();
	}

	public static void main(String[] args) {
		 SoftReference<Grocery> bean = new SoftReference<Grocery>(new Grocery("willlee")); 
		 System.out.println(bean.get());// ¡°name:10¡±
	}
}
