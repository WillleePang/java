package com.willlee.concurrency.executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExam {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(2);
        scheduler.scheduleAtFixedRate(new PrintLog(), 1, 1, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable() {
            public void run() {
                System.out.println("cancel beep");
            }
        }, 10, TimeUnit.SECONDS);    
    }
}

class PrintLog implements Runnable {
    public void run() {
        try {
            System.out.println("wtf!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}