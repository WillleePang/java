package com.willlee.designpatterns.singleton;


import java.util.HashMap;

public class ThreeSingleton {
	private final static String DEFAULT_PREKEY = "cache";// Ϊ����ʹ�õ� key ����һ��ǰ׺
	private static HashMap<String, ThreeSingleton> map = new HashMap<String, ThreeSingleton>();// ���建��ʵ��������
	private static int number = 1;// �����ʼ��ʵ����ĿΪ 1
	private final static int NUM_MAX = 3;

	private ThreeSingleton() {

	}

	public static synchronized ThreeSingleton getInstance() {
		// ͨ�����������ʽ��������
		String key = DEFAULT_PREKEY + number;
		ThreeSingleton threeSingleton = map.get(key);
		if (threeSingleton == null) {
			threeSingleton = new ThreeSingleton();
			map.put(key, threeSingleton);
		}
		number++;// ʵ����Ŀ�� 1
		if (number > NUM_MAX) {
			number = 1;
		}
		return threeSingleton;
	}

	public static void main(String args[]) {
		ThreeSingleton t1 = getInstance();
		ThreeSingleton t2 = getInstance();
		ThreeSingleton t3 = getInstance();
		ThreeSingleton t4 = getInstance();
		ThreeSingleton t5 = getInstance();
		ThreeSingleton t6 = getInstance();
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		System.out.println(t4.toString());
		System.out.println(t5.toString());
		System.out.println(t6.toString());
	}
}