package com.willlee.designpatterns.proxy.lazyload;

public class Client {
	public static void main(String[] args) {
		IDBQuery q = new DBQueryProxy(); // 使用代里
		//DBQuery dbquery = new DBQuery();
		q.request(); // 在真正使用时才创建真实对象
	}
}
