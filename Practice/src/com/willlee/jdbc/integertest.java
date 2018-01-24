package com.willlee.jdbc;

public class integertest {
	public static void main(String[] args) {
		int i = 128;
		int i1 = new Integer(128);
		System.out.println(i == i1);
		int i2 = 205;
		int i3 = new Integer(205);
		System.out.println(i2 == i3);

		int I = 5, J = 5;
		System.out.println((I++) + (I++) + (I++));
		System.out.println((++J) + (++J) + (++J));
	}

	public int getInt() {
		char a = '1';
		return a;
	}
}
