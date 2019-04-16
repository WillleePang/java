package com.willlee.concurrency.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

//1. 队列中的对象都是Delayed对象，它实现了getDelay和compareTo两个方法； 
//2. 队列中的对象按照优先级（按照compareTo）进行了排序，队列头部是最先超时的对象； 
//3. take方法会在没有超时对象时一直阻塞，直到有对象超时；poll方法会在没有超时对象时返回null。 
//4. 队列中不允许存储null，且iterator方法返回的值不能确保按顺序排列。 
//DelayQueue通过PriorityQueue，使得超时的对象最先被处理，将take对象的操作阻塞住，避免了遍历方式的轮询，提高了性能。在很多需要回收超时对象的场景都能用上。
public class DelayQueueExam {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayElement> queue = new DelayQueue<DelayElement>();
        for (int i = 0; i < 10; i++) {
            queue.put(new DelayElement(1000 * i, "DelayElement" + i));
        }
        while (!queue.isEmpty()) {
            DelayElement delayElement = queue.take();
            System.out.println(delayElement.getName());
        }
    }

    static class DelayElement implements Delayed {
        private long expired;
        private final String name;

        DelayElement(int delay, String name) {
            this.name = name;
            expired = System.currentTimeMillis() + delay;
        }

        public String getName() {
            return name;
        }

        public long getDelay(TimeUnit unit) {
            return unit.convert(expired - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public int compareTo(Delayed o) {
            long d = (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
            return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
        }
    }
}
