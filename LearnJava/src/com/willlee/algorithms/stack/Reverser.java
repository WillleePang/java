package com.willlee.algorithms.stack;

public class Reverser {
	private String input;
	private String output;

	public Reverser(String in) {
		input = in;
	}

	public String doRev() {
		int stackSize = input.length();
		StackY stack = new StackY(stackSize);

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			stack.push(ch);
		}
		output = "";
		while(!stack.isEmpty()){
			char ch = stack.pop();
			output = output+ch;
		}
		return output;
	}
}
