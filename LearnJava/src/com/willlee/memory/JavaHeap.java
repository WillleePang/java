package com.willlee.memory;

import java.util.ArrayList;

/**
 * 所有对象的实例分配都在Java堆上分配内存，堆大小由-Xmx和-Xms来调节
 * 加上JVM参数-verbose:gc -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError，就能很快报出OOM：
 * @author Administrator
 * 
 */
public class JavaHeap {
	static class OOMObject {
	}

	public static void main(String[] args) {
		ArrayList<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
