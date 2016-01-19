package com.willlee.designpatterns.proxy.lazyload;

public class DBQuery implements IDBQuery {

	public DBQuery() {
		try {
			Thread.sleep(1000);// 假设数据库连接等耗时操作
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("初始化DBQuery完毕");
	}

	@Override
	public String request() {
		// TODO Auto-generated method stub
		return "request string";
	}

}
