package com.willlee.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
	static int size;
	static int count;
	static char[] arrChar = new char[100];

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
		String input = getString();
		size = input.length();
		count = 0;
		for (int j = 0; j < size; j++) {
			arrChar[j] = input.charAt(j);
		}
		doanagram(size);
	}
	
	public static void doanagram(int newSize) {
		if (newSize == 1) {// if too small,go no further
			return;
		}
		for (int i = 0; i < newSize; i++) {//for each position
			doanagram(newSize - 1);
			if (newSize == 2)
				displayWord();
			rotate(newSize);
		}
	}
	
	//format output
	public static void displayWord() {
		if (count < 99) {
			System.out.print(" ");
		}
		if (count < 9) {
			System.out.print(" ");
		}
		System.out.print(++count + " ");
		for (int j = 0; j < size; j++) {
			System.out.print(arrChar[j]);
		}
		System.out.print("  ");
		System.out.flush();
		if (count % 6 == 0) {
			System.out.println("");
		}
	}

	//rotate left all chars from position to end
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position];//save first letter
		for (j = position + 1; j < size; j++) {//shift others left
			arrChar[j - 1] = arrChar[j];
		}
		arrChar[j - 1] = temp;//put first on right
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
