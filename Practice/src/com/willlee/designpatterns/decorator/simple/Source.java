package com.willlee.designpatterns.decorator.simple;

public class Source implements Sourceble {

	@Override
	public void operation() {
		System.out.println("原始类的方法");
	}

}
