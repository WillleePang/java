package com.willlee.concurrency.util;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExam {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            public void run() {
                System.out.println("======== all threads have arrived at the checkpoint ===========");
            }
        });
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(new Traveler("Traveler1", barrier));
        service.submit(new Traveler("Traveler2", barrier));
        service.submit(new Traveler("Traveler3", barrier));
        service.shutdown();
    }

    private static class Traveler implements Runnable {
        private final String name;
        private final CyclicBarrier barrier;
        private static Random rand = new Random(47);

        Traveler(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        public void run() {
            try {
                TimeUnit.SECONDS.sleep(rand.nextInt(5));
                System.out.println(name + " arrived at Beijing.");
                barrier.await();
                TimeUnit.SECONDS.sleep(rand.nextInt(5));
                System.out.println(name + " arrived at Shanghai.");
                barrier.await();
                TimeUnit.SECONDS.sleep(rand.nextInt(5));
                System.out.println(name + " arrived at Guangzhou.");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
