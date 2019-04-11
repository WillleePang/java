package com.pangwilllee.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExam {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Task("task1"));
        service.execute(new Task("task2"));
        service.execute(new Task("task3"));
        service.execute(new Task("task4"));
        service.execute(new Task("task6"));
        service.execute(new Task("task7"));
        service.execute(new Task("task8"));
        service.execute(new Task("task9"));
        service.execute(new Task("task10"));
        service.execute(new Task("task11"));
        service.execute(new Task("task12"));
        service.execute(new Task("task13"));
        service.shutdown();
    }
}

class Task implements Runnable {
    private final String name;

    Task(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(name + "-[" + i + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}