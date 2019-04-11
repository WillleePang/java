package com.pangwilllee.concurrency.queue;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

//1. 队列中的元素总是按照“自然顺序”进行排序，或者根据构造函数中给定的Comparator进行排序； 
//2. 队列中不允许存在null，也不允许存在不能排序的元素； 
//3. 对于排序值相同的元素，其序列是不保证的，当然你可以自己扩展这个功能； 
//4. 队列容量是没有上限的，但是如果插入的元素超过负载，有可能会引起OutOfMemory异常； 
//5. 使用迭代子iterator()对队列进行轮询，其顺序不能保证； 
//6. 它还具有BlockingQueue的put和take方法，但是由于队列容量没有上线，所以put方法是不会被阻塞的，但是take方法是会被阻塞的； 
//7. 可以给定初始容量，这个容量会按照一定的算法自动扩充。 
//总之，在需要使用优先级队列，且还有阻塞需求时，就可以使用PriorityBlockingQueue了。
public class PriorityBlockingQueueExam {
    public static void main(String[] args) {
        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<String>(3, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) < 0) {
                    return 1;
                } else if (o1.compareTo(o2) > 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            service.submit(new Producer("Producer" + i, queue));
        }
        for (int i = 0; i < 5; i++) {
            service.submit(new Consumer("Consumer" + i, queue));
        }
        service.shutdown();
    }

    static class Producer implements Runnable {
        private final String name;
        private final PriorityBlockingQueue<String> queue;
        private static Random rand = new Random(System.currentTimeMillis());

        Producer(String name, PriorityBlockingQueue<String> queue) {
            this.name = name;
            this.queue = queue;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                String str = "Product" + rand.nextInt(1000);
                queue.put(str);
                System.out.println("->" + name + " put " + str);
                try {
                    TimeUnit.SECONDS.sleep(rand.nextInt(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + " is over");
        }
    }

    static class Consumer implements Runnable {
        private final String name;
        private final PriorityBlockingQueue<String> queue;
        private static Random rand = new Random(System.currentTimeMillis());

        Consumer(String name, PriorityBlockingQueue<String> queue) {
            this.name = name;
            this.queue = queue;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    String str = queue.take();
                    System.out.println("<-" + name + " take " + str);
                    TimeUnit.SECONDS.sleep(rand.nextInt(5));
                }
                System.out.println(name + " is over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
