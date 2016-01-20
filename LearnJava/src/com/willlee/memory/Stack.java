package com.willlee.memory;

/**
 * 栈是存放线程调用方法时存储局部变量表，操作，方法出口等与方法执行相关的信息，栈大小由Xss来调节，方法调用层次太多会撑爆这个区域
 * 设置JVM参数：-Xss128k
 * 
 * @author Administrator
 * 
 */
public class Stack {
	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		Stack oom = new Stack();
		try {
			oom.stackLeak();
		} catch (Throwable err) {
			System.out.println("Stack length:" + oom.stackLength);
			throw err;
		}

	}
}
