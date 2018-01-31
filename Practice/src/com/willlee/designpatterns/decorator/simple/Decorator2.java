package com.willlee.designpatterns.decorator.simple;

public class Decorator2 implements Sourceble {
	private Sourceble sourceble;

	public Decorator2(Sourceble sourceble) {
		super();
		this.sourceble = sourceble;
	}

	public void operation() {
		System.out.println("�ڶ���װ����ǰ");
		sourceble.operation();
		System.out.println("�ڶ���װ������");

	}
}
