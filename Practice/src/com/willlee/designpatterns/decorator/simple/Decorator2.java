package com.willlee.designpatterns.decorator.simple;

public class Decorator2 implements Sourceble {
	private Sourceble sourceble;

	public Decorator2(Sourceble sourceble) {
		super();
		this.sourceble = sourceble;
	}

	@Override
	public void operation() {
		System.out.println("第二个装饰器前");
		sourceble.operation();
		System.out.println("第二个装饰器后");

	}
}
