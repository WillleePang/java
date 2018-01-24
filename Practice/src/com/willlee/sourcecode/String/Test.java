package com.willlee.sourcecode.String;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		String s = "willlee";
		String s1 = new String(s.toCharArray(), 0, 1);
		System.out.println(s1.toString());

		String s2 = "h,o,l,l,i,s,c,h,u,a,n,g";
		String[] splitAll = s2.split(",");
		String[] splitFive = s2.split(",", 5);
		System.out.println(Arrays.toString(splitAll));
		System.out.println(Arrays.toString(splitFive));
		for (String c : splitFive) {
			System.out.println(c);
		}

		// String∂‘°∞+°±µƒ÷ÿ‘ÿ
		// String s3 = "willlee";
		// String s4 = s3 + "pang";
		// String s4 = (new
		// StringBuilder(String.valueOf("string"))).append("pang").toString();

		int i = 5;
		String i1 = "" + i;
		String i2 = String.valueOf(i);
		String i3 = Integer.toString(i);
		System.out.println(i1.equals(i2));
		System.out.println(i2 == i3);
	}
}
