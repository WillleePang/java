package com.willlee.sourcecode.Enum.code;

enum Color {
	RED, GREEN, YELLOW
}

enum Season {
	SPRING, SUMMER, WINTER
}

public class EnumTest {
	public static void main(String[] args) {
		System.out.println(Color.RED.ordinal());
		System.out.println(Season.SPRING.ordinal());
	}
}
