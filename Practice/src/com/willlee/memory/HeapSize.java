package com.willlee.memory;

import java.util.Vector;

public class HeapSize {
	//-XX:+PrintGCDetails -Xms10M -Xmx40M -XX:MinHeapFreeRatio=40 -XX:MaxHeapFreeRatio=50
	public static void main(String args[]) throws InterruptedException {
		Vector v = new Vector();
		while (true) {
			byte[] b = new byte[1024 * 1024];
			v.add(b);
			if (v.size() == 10) {
				v = new Vector();
			}
			Thread.sleep(1);
		}
	}
}
