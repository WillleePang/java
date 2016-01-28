package com.willlee.memory;

public class BigObj2Old {
	public static void main(String[] args) {
		//-XX:+PrintGCDetails -Xmx20M -Xms20M -XX:PetenureSizeThreshold=1000000
		byte[] b;
		b = new byte[1024 * 1024];// 分配一个 1MB 的对象
	}
}
