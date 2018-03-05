package com.willlee.mutilthread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		// sample1();
		// sample2();
		// sample3();
		// sample4();
		// simple5();
		simple6();
	}

	private static void sample1() {
		final String THREAD_SAVE_ORDER = "THREAD_SAVE_ORDER";
		final String THREAD_SAVE_ADDR = "THREAD_SAVE_ADDR";
		Thread threadOne = new Thread(new Runnable() {
			public void run() {
				System.out.println("save ORDER thread");
				try {
					Thread.sleep(500);
				} catch (Exception e) {

					e.printStackTrace();
				}
				throw new NullPointerException();
			}
		}, THREAD_SAVE_ORDER);

		Thread threadTwo = new Thread(new Runnable() {
			public void run() {
				System.out.println("save ADDR thread");
			}
		}, THREAD_SAVE_ADDR);

		threadOne.start();
		threadTwo.start();
	}

	private static void sample2() {
		ThreadPoolExecutor executorOne = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
				new LinkedBlockingQueue<Runnable>(), new NamedThreadFactory("ASYN-ACCEPT-POOL"));
		ThreadPoolExecutor executorTwo = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
				new LinkedBlockingQueue<Runnable>(), new NamedThreadFactory("ASYN-PROCESS-POOL"));
		// 接受用户链接模块
		executorOne.execute(new Runnable() {
			public void run() {
				System.out.println("接受用户链接线程");
				throw new NullPointerException();
			}
		});
		// 具体处理用户请求模块
		executorTwo.execute(new Runnable() {
			public void run() {
				System.out.println("具体处理业务请求线程");
			}
		});

		executorOne.shutdown();
		executorTwo.shutdown();
	}

	static class NamedThreadFactory implements ThreadFactory {
		private static final AtomicInteger poolNumber = new AtomicInteger(1);
		private final ThreadGroup group;
		private final AtomicInteger threadNumber = new AtomicInteger(1);
		private final String namePrefix;

		NamedThreadFactory(String name) {
			SecurityManager s = System.getSecurityManager();
			group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
			if (null == name || name.isEmpty()) {
				name = "pool";
			}
			namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
		}

		public Thread newThread(Runnable r) {
			Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
			if (t.isDaemon())
				t.setDaemon(false);
			if (t.getPriority() != Thread.NORM_PRIORITY)
				t.setPriority(Thread.NORM_PRIORITY);
			return t;
		}
	}

	public static void sample3() {
		final int ThreadNum = 10;
		CountDownLatch countDownLatch = new CountDownLatch(ThreadNum);
		ExecutorService executorService = Executors.newFixedThreadPool(ThreadNum);
		for (int i = 0; i < ThreadNum; ++i) {
			executorService.execute(new Person(countDownLatch, i + 1));
		}

		System.out.println("waiting all staffs sign");
		try {
			countDownLatch.await();
			System.out.println("all staffs have signed, let's go eat!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}

	static class Person implements Runnable {
		private CountDownLatch countDownLatch;
		private int index;

		public Person(CountDownLatch cdl, int index) {
			this.countDownLatch = cdl;
			this.index = index;
		}

		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("person " + index + " signing!");
			countDownLatch.countDown();
		}
	}

	private static int num = 0;
	private static boolean ready = false;

	public static class ReadThread extends Thread {
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				if (ready) {
					System.out.println(num + num);
				}
				System.out.println("read thread....");
			}
		}
	}

	public static class Writethread extends Thread {
		public void run() {
			num = 2;
			ready = true;
			System.out.println("writeThread set over...");
		}
	}

	public static void sample4() throws InterruptedException {
		ReadThread rt = new ReadThread();
		rt.start();

		Writethread wt = new Writethread();
		wt.start();

		Thread.sleep(10);
		rt.interrupt();
		System.out.println("main exit");
	}

	public static class SleepInterrupt extends Object implements Runnable {
		public void run() {
			try {
				System.out.println("thread-sleep for 2000 seconds");
				Thread.sleep(2000000);
				System.out.println("thread -waked up");
			} catch (InterruptedException e) {
				System.out.println("thread-interrupted while sleeping");
				return;
			}
		}
	}

	public static void simple5() throws InterruptedException {

		SleepInterrupt si = new SleepInterrupt();
		Thread t = new Thread(si);
		t.start();
		// 主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main() - interrupting other thread");
		// 中断线程t
		t.interrupt();
		System.out.println("main() - leaving");

	}

	public static class Task implements Callable<Integer> {
		public Integer call() throws Exception {
			System.out.println("child thread is computing!");
			Thread.sleep(1000);
			int sum = 0;
			for (int i = 0; i < 100; i++)
				sum += i;
			return sum;
		}
	}

	public static void simple6() throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
		executor.submit(futureTask);
		System.out.println("主线程在执行任务");
		try {
			System.out.println("task运行结果" + futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("所有任务执行完毕");
		executor.shutdown();
	}
}
