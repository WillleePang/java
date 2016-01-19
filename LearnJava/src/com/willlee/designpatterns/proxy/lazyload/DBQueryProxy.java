package com.willlee.designpatterns.proxy.lazyload;

public class DBQueryProxy implements IDBQuery {

	public DBQueryProxy() {
		super();
		System.out.println("初始化DBQueryProxy完毕");
	}

	private DBQuery real = null;

	@Override
	public String request() {
		// TODO Auto-generated method stub
		// 在真正需要的时候才能创建真实对象，创建过程可能很慢
		if (real == null) {
			real = new DBQuery();
		}// 在多线程环境下，这里返回一个虚假类，类似于 Future 模式
		return real.request();
	}

}
