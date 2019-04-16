package com.willlee.concurrency.queue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/*
 * 它的作者Doug Lea 这样评价它：TransferQueue是一个聪明的队列，它是ConcurrentLinkedQueue, SynchronousQueue (在公平模式下), 
 * 无界的LinkedBlockingQueues等的超集。 所以，在合适的场景中，请尽量使用TransferQueue，目前它只有一个实现类LinkedTransferQueue。
*/
public class TransferQueueExam2 {
    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<String>();
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new Producer("Producer1", queue));
        service.submit(new Producer("Producer2", queue));
        service.submit(new Consumer("Consumer1", queue));
        service.submit(new Consumer("Consumer2", queue));
        service.shutdown();
    }

    static class Producer implements Runnable {
        private final String name;
        private final TransferQueue<String> queue;

        Producer(String name, TransferQueue<String> queue) {
            this.name = name;
            this.queue = queue;
        }

        public void run() {
            System.out.println(name + " begin transfer objects");

            try {
                for (int i = 0; i < 5; i++) {
                    queue.transfer(name + "_Product" + i);
                    System.out.println(name + " transfer " + name + "_Product" + i);
                }
                System.out.println(name + " after transformation");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is over");
        }
    }

    static class Consumer implements Runnable {
        private final String name;
        private final TransferQueue<String> queue;
        private static Random rand = new Random(System.currentTimeMillis());

        Consumer(String name, TransferQueue<String> queue) {
            this.name = name;
            this.queue = queue;
        }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    String str = queue.take();
                    System.out.println(name + " take " + str);
                    TimeUnit.SECONDS.sleep(rand.nextInt(5));
                }
                System.out.println(name + " is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
