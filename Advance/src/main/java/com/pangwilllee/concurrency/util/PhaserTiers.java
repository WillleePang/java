package com.pangwilllee.concurrency.util;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * 原则上来说，一个Phaser可以支持Integer.MAX_VALUE个parties，但是考虑到性能问题，目前Jdk1.
 * 7中仅支持65535个parties。一个Phaser如果有大量的parties，那么线程竞争的开销会很大，导致性能降低，因此Phaser支持分层，
 * 由一个父Phaser自动控制多个子Phaser。在一个分层的Phaser体系中，子Phaser中parties的注册与注销会自动被父Phaser管理。
 * 当一个子Phaser的parties降低到0时，它自动从父Phaser中注销，当一个子Phaser的parties上升到大于0时，
 * 它自动在Phaser中注册。
 * 
 * @author pangweili
 *
 */
public class PhaserTiers {
    final static int TASKS_PER_PHASER = 4;

    public static void main(String[] args) {
        Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("================== all threads is arrived ===================");
                return super.onAdvance(phase, registeredParties);
            }
        };
        Task[] tasks = new Task[12];
        build(tasks, 0, 12, phaser);
    }

    static void build(Task[] tasks, int lo, int hi, Phaser ph) {
        if (hi - lo > TASKS_PER_PHASER) {
            // 将数组分成三段，0-4；4-8；8-12，然后每个分段有一个子phaser
            for (int i = lo; i < hi; i += TASKS_PER_PHASER) {
                int j = Math.min(i + TASKS_PER_PHASER, hi);
                build(tasks, i, j, new Phaser(ph));
            }
        } else {
            for (int i = lo; i < hi; ++i) {
                tasks[i] = new Task(ph);
                tasks[i].start();
            }
        }
    }

    private static class Task extends Thread {
        private static Random rand = new Random(System.currentTimeMillis());
        final Phaser phaser;

        private Task(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.register();
            System.out.println(Thread.currentThread() + " is working.");
            try {
                int seconds = rand.nextInt(5) + 1;
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phaser.arriveAndAwaitAdvance();
        }
    }
}
