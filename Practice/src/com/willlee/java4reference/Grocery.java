package com.willlee.java4reference;

/**
 * 创建一个引用对象ref
 * 
 * @author TianYou
 */
public class Grocery {
	private static final int SIZE = 10000;
	private double[] d = new double[SIZE];
	private String id;

	public Grocery(String id) {
		this.id = id;
	}

	public String toString() {
		return id;
	}

	public void finalize() {
		System.out.println("Finalizing ... " + id);
	}

	public double[] getD() {
		return d;
	}

	public void setD(double[] d) {
		this.d = d;
	}

}
