package com.pangwilllee.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExam {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final BoundedBuffer buffer = new BoundedBuffer();
        service.execute(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        String str = "string" + i;
                        buffer.put(str);
                        System.out.println(Thread.currentThread() + " put " + str);
                        TimeUnit.MILLISECONDS.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 1000; i++) {
                        String str = (String) buffer.take();
                        System.out.println(Thread.currentThread() + " take " + str);
                        TimeUnit.MILLISECONDS.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }

    private static class BoundedBuffer {
        final Lock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();//不满
        final Condition notEmpty = lock.newCondition();//不空

        final Object[] items = new Object[100];
        int putptr, takeptr, count;//数组中object的数量

        public void put(Object x) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length)//如果容器全满
                    notFull.await();//则阻塞不满的条件
                items[putptr] = x;//如果容器还没有满，则放入object
                if (++putptr == items.length)//如果正好满了
                    putptr = 0;//则将指针移到数组头部
                ++count;
                notEmpty.signal();//释放不空的条件
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0)//如果容器全空
                    notEmpty.await();//则阻塞不空的条件
                Object x = items[takeptr];//如果容器还没有全空，取出object
                if (++takeptr == items.length)//如果容易已经取空了
                    takeptr = 0;//则将指针以到数组头部
                --count;
                notFull.signal();//释放不满的新号
                return x;
            } finally {
                lock.unlock();
            }
        }
    }
}
