package com.willlee.designpatterns.singleton;

class InternalSingleton {
	private InternalSingleton() {
	}

	private static class SingletonHolder {
		private final static InternalSingleton INSTANCE = new InternalSingleton();
	}

	public static InternalSingleton getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
