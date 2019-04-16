package com.willlee.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExam {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            service.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread() + " ready to get lock");
                        lock.lock();
                        System.out.println(Thread.currentThread() + " get the lock");
                        for (int j = 0; j < 5; j++) {
                            System.out.println(Thread.currentThread() + " is running, number = " + j);
                            TimeUnit.MILLISECONDS.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                        System.out.println(Thread.currentThread() + " unlock");
                    }
                }
            });
        }
        service.shutdown();
    }
}
