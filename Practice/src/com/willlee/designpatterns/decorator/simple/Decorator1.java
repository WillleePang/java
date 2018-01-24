package com.willlee.designpatterns.decorator.simple;

public class Decorator1 implements Sourceble {
	private Sourceble sourceble;

	public Decorator1(Sourceble sourceble) {
		super();
		this.sourceble = sourceble;
	}

	@Override
	public void operation() {
		System.out.println("第一个装饰器前");
		sourceble.operation();
		System.out.println("第一个装饰器后");

	}

}
