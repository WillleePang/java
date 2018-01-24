package com.willlee.sourcecode.Enum.statusmachine;

public class Main {
	public enum Test {
		ONE, TWO, THREE;
	}

	public static void main(String args[]) {
		CHANGE ob = new CHANGE();
		for (int i = 0; i < 3; i++) {
			ob.change();
		}
	}

	public static class CHANGE {
		Test ts = Test.ONE;
		public void change() {
			switch (ts) {
			case ONE:
				ts = Test.TWO;
				System.out.println("this is test one");
				break;
			case TWO:
				ts = Test.THREE;
				System.out.println("this is test two");
				break;
			case THREE:
				ts = Test.ONE;
				System.out.println("this is test three");
				break;
			}
		}
	}
}
