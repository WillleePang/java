package com.willlee.designpatterns.proxy.dynamicproxy;

public class Client {
	public static void main(String[] args) {
		BookProxyLib cglib = new BookProxyLib();
		BookProxyImpl bookCglib = (BookProxyImpl) cglib
				.getInstance(new BookProxyImpl());
		bookCglib.addBook();
	}
}