package com.willlee.designpatterns.singleton;

public class CommonSingleton {
	
	private CommonSingleton() {
		System.out.println("Singleton is create");
	}

	private static CommonSingleton instance = new CommonSingleton();

	public static CommonSingleton getInsatnce() {
		return instance;
	}
}
