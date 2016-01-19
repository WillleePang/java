package com.willlee.designpatterns.flyweight;

public class ConcreteFlyweight extends Flyweight {
	private String string;

	public ConcreteFlyweight(String string) {
		super();
		this.string = string;
	}

	@Override
	public void operation() {
		System.out.println("Concrete---Flyweight : " + string);  
	}
}
