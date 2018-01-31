package com.willlee.designpatterns.decorator.simple;

public class Decorator1 implements Sourceble {
	private Sourceble sourceble;

	public Decorator1(Sourceble sourceble) {
		super();
		this.sourceble = sourceble;
	}

	public void operation() {
		System.out.println("��һ��װ����ǰ");
		sourceble.operation();
		System.out.println("��һ��װ������");

	}

}
