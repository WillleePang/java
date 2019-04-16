package com.willlee.concurrency.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁ReentrantWriteReadLock的用法比较难以理解，因此用一个大家都熟悉的场景来说明。假设一个班级有一块黑板（共享资源），
 * 有多个老师都需要在黑板上书写。老师在写之前，先要获取写锁（writeLock），在写的时候其他的老师和学生都不能在黑板上写或者读，老师写完之后，释放写锁。
 * 学生在读黑板之前，先要获取读锁（readLock），多个学生可以同时获取读锁，因此多个学生可以同时读取黑板上的内容，在读的时候其他老师不能在黑板上写，
 * 学生读完之后，释放读锁。直至所有学生都释放完读锁，才能够由老师获取写锁。
 * 
 * 总结规则如下： 1.写锁是排它锁，一旦被获取，其他竞争写锁的线程被阻塞，其他竞争读锁的线程也被阻塞； 2.写锁被释放后，其他的线程可以竞争写锁或者读锁；
 * 3.读锁是共享锁，它可以同时被多个线程获取，但是读锁和写锁是不能同时被不同的线程获取的； 4.所有的读锁被释放后，其他的线程可以竞争写锁。
 * 
 * 
 * @author pangweili
 *
 */
public class ReentrantReadWriteLockExam {
    public static Random rand = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        StringBuilder blackboard = new StringBuilder(100);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Teacher(lock, "Chinese Teacher", blackboard));
        service.execute(new Teacher(lock, "English Teacher", blackboard));
        service.execute(new Student(lock, "Wang", blackboard));
        service.execute(new Student(lock, "Li", blackboard));
        service.execute(new Student(lock, "Zhang", blackboard));
        service.shutdown();
    }

    private static class Teacher extends Thread {
        final private ReentrantReadWriteLock lock;
        final private String name;
        final private StringBuilder blackboard;
        private AtomicInteger id = new AtomicInteger(0);

        private Teacher(ReentrantReadWriteLock lock, String name, StringBuilder blackboard) {
            this.lock = lock;
            this.name = name;
            this.blackboard = blackboard;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                try {
                    lock.writeLock().lock();
                    System.out.println(name + " get write lock");
                    blackboard.delete(0, 99)
                            .append(name + " has written on the blackboard, number = " + id.getAndIncrement());
                    System.out.println(name + " write content:" + blackboard);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.writeLock().unlock();
                    System.out.println(name + " release write lock");
                }
            }
        }
    }

    private static class Student extends Thread {
        final private ReentrantReadWriteLock lock;
        final private String name;
        final private StringBuilder blackboard;

        private Student(ReentrantReadWriteLock lock, String name, StringBuilder blackboard) {
            this.lock = lock;
            this.name = name;
            this.blackboard = blackboard;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                try {
                    lock.readLock().lock();
                    System.out.println(name + " get read lock");
                    System.out.println(name + " read the blackboard:" + blackboard);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.readLock().unlock();
                    System.out.println(name + " release the read lock");
                }
            }
        }
    }
}
