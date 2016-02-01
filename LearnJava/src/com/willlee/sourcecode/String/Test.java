package com.willlee.sourcecode.String;

public class Test {
	public static void main(String[] args) {
		String s = "willlee";
		String s1 = new String(s.toCharArray(), 0, 1);
		System.out.println(s1.toString());
	}
}
