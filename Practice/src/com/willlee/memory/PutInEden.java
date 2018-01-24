package com.willlee.memory;

public class PutInEden {

	public static void main(String[] args) {
		// 开启了详细GC日志模式
		// -XX:+PrintGCDetails -Xmx20M -Xms20M
		// -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn4M
		// byte[] b1, b2, b3, b4;// 定义变量
		// b1 = new byte[1024 * 1024];// 分配 1MB 堆空间，考察堆空间的使用情况
		// b2 = new byte[1024 * 1024];
		// b3 = new byte[1024 * 1024];
		// b4 = new byte[1024 * 1024];

		// -XX:+PrintGCDetails -Xmx1000M -Xms500M -Xmn100M -XX:SurvivorRatio=8
		// byte[] b1, b2, b3;
		// b1 = new byte[1024 * 512];// 分配 0.5MB 堆空间
		// b2 = new byte[1024 * 1024 * 90];// 分配 4MB 堆空间
		// b3 = new byte[1024 * 1024 * 50];
		// b3 = null; // 使 b3 可以被回收
		// b3 = new byte[1024 * 1024 * 4];// 分配 4MB 堆空间
		
	}
}
