package com.willlee.designpatterns.flyweight;

import java.util.Hashtable;

public class FlyweightFactory {
	private Hashtable<String, Flyweight> flyweights = new Hashtable<String, Flyweight>();

	public FlyweightFactory() {
	}

	public Flyweight getFlyWeight(String key) {
		Flyweight flyweight = (Flyweight) flyweights.get(key);
		if (flyweight == null) {
			flyweight = new ConcreteFlyweight((String) key);
			flyweights.put(key, flyweight);
		}
		return flyweight;
	}

	public int getFlyweightSize() {
		return flyweights.size();
	}
}
