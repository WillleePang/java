package com.willlee.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX1 {
	private int maxSize;// size of stackx array
	private int[] stackArray;
	private int top;// top of stack

	public StackX1(int s) {// constructor
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int p) {
		stackArray[++top] = p;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}

public class StackTriangleApp1 {
	static int theNumber;
	static int theAnswer;
	static StackX1 theStack;

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
		theNumber = getInt();
		stackTriangle();
		System.out.println("Triangle = " + theAnswer);
	}

	public static void stackTriangle() {
		theStack = new StackX1(10000);
		theAnswer = 0;
		while (theNumber > 0) {
			theStack.push(theNumber);
			--theNumber;
		}
		while (!theStack.isEmpty()) {
			int newInt = theStack.pop();
			theAnswer += newInt;
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
