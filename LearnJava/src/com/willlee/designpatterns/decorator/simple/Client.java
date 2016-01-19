package com.willlee.designpatterns.decorator.simple;

public class Client {
	public static void main(String[] args) {
		 Sourceble source = new Source();  
		 Sourceble obj = new Decorator1(new Decorator2(source));
		 obj.operation();
	}
}
