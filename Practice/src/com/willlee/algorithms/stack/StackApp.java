package com.willlee.algorithms.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackApp {
	public static void main(String[] args) throws IOException {
		StackX stack = new StackX(5);
		stack.push(20);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(80);
		while (!stack.isEmpty()) {
			long value = stack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");

		String input, output;
		while (true) {
			System.out.print("Enter a string: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			Reverser reverser = new Reverser(input);
			output = reverser.doRev();
			System.out.println("Reversed: " + output);
		}

		while (true) {
			System.out.print("Enter string containing delimiters: ");
			System.out.flush();
			input = getString();
			if (input.equals("")) {
				break;
			}
			BracketChecker checker = new BracketChecker(input);
			checker.check();
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
