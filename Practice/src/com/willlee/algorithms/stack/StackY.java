package com.willlee.algorithms.stack;

public class StackY {
	private int maxSize;
	private char[] stackArray;
	private int top;

	public StackY(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char j) {
		if (!isFull()) {
			stackArray[++top] = j;
		} else {
			System.out.println("can't insert, stack is full");
		}
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
}
