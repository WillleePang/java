package com.pangwilllee.concurrency.lock;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class UnsafeParkExam {
    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        final Unsafe unsafe = (Unsafe) field.get(null);
        final Thread t1 = new Thread() {
            public void run() {
                Thread.currentThread().setName("t1");
                System.out.println(Thread.currentThread().getName() + " before park");
                // park 100 seconds
                unsafe.park(false, TimeUnit.NANOSECONDS.convert(100, TimeUnit.SECONDS));
                System.out.println(Thread.currentThread().getName() + " after park");
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                try {
                    Thread.currentThread().setName("t2");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " unpark t1");
                    unsafe.unpark(t1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t3 = new Thread() {
            public void run() {
                Thread.currentThread().setName("t3");
                System.out.println(Thread.currentThread().getName() + " park 5 seconds");
                // park 5 seconds
                unsafe.park(true, System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
                System.out.println(Thread.currentThread().getName() + " after park");
            }
        };
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
