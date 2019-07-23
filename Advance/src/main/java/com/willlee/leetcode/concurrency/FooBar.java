package com.willlee.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//leetcode1115
public class FooBar {
    private int n;
    private int st = 1;
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            if (st != 1) {
                condition1.await();
            }
            st = 2;
            // printFoo.run() outputs "foo". Do not change or remove this
            // line.
            printFoo.run();
            condition2.signal();
        }
        lock.unlock();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        for (int i = 0; i < n; i++) {
            if (st != 2) {
                condition2.await();
            }
            st = 1;
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            condition1.signal();
        }
        lock.unlock();
    }
}
