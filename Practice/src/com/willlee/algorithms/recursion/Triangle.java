package com.willlee.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {

	static int theNumber;

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
		theNumber = getInt();
		int theAnwser = triangle(theNumber);
		System.out.println("Triangle = " + theAnwser);
	}

	public static int triangle(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (n + triangle(n - 1));
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
