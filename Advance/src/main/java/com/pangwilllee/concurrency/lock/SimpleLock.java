package com.pangwilllee.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 根据JUC（Java Util
 * Concurrency）作者的建议，AQS的使用方法要遵循上面这个模式。一是使用一个内部类Sync来继承AQS，并实现AQS的相关方法，
 * 一般是tryAcquire和tryRelease（排它锁），或者tryAcquireShared和tryReleaseShared（共享锁）；
 * 二是在内部使用一个代理模式来实现锁的功能，这样做的好处是可以让暴露出的同步、互斥方法名由程序员自行决定，例如各种锁可以使用lock、unlock，
 * Semaphore可以使用acquire和release，CountDownLatch可以使用await和countDown。
 * 
 * 
 * @author pangweili
 *
 */
public class SimpleLock {
    private static class Sync extends AbstractQueuedSynchronizer {

        private static final long serialVersionUID = 3111851462936038572L;

        @Override
        protected boolean tryAcquire(int ignore) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int ignore) {
            setState(0);
            return true;
        }

        protected Sync() {
            super();
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    private static class MyThread extends Thread {
        private final String name;
        private final SimpleLock lock;

        private MyThread(String name, SimpleLock lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(name + " get the lock");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(name + " release the lock");
            }
        }
    }

    public static void main(String[] args) {
        final SimpleLock mutex = new SimpleLock();
        MyThread t1 = new MyThread("t1", mutex);
        MyThread t2 = new MyThread("t2", mutex);
        MyThread t3 = new MyThread("t3", mutex);
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
        System.out.println("main thread exit!");
    }
}
