package com.willlee.concurrency.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentLinkedQueueExam {
    private static final int TEST_INT = 10000000;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Queue<Integer> queue = null;
        // Time span = 19189 queue size =10063872
        queue = new LinkedList<Integer>();
        // Time span = 16800 queue size = 0
        queue = new LinkedBlockingQueue<Integer>();
        // Time span = 7963 queue size = 0
        queue = new ArrayBlockingQueue<Integer>(TEST_INT * 5);
        // Time span = 16128 queue size = 0
        queue = new ConcurrentLinkedQueue<Integer>();
        System.out.println("Using " + queue.getClass().getSimpleName());

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.submit(new Putter(queue, "Putter" + i));
        }
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < 5; i++) {
            service.submit(new Getter(queue, "Getter" + i));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        long end = System.currentTimeMillis();
        System.out.println("Time span = " + (end - start));
        System.out.println("queue size = " + queue.size());
    }

    static class Putter implements Runnable {
        private final Queue<Integer> queue;
        private final String name;

        Putter(Queue<Integer> queue, String name) {
            this.queue = queue;
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < TEST_INT; i++) {
                queue.offer(1);
            }
            System.out.println(name + " is over");
        }
    }

    static class Getter implements Runnable {
        private final Queue<Integer> queue;
        private final String name;

        Getter(Queue<Integer> queue, String name) {
            this.queue = queue;
            this.name = name;
        }

        public void run() {
            int i = 0;
            while (i < TEST_INT) {
                synchronized (Getter.class) {
                    if (!queue.isEmpty()) {
                        queue.poll();
                        i++;
                    }
                }
            }
            System.out.println(name + " is over");
        }
    }
}
