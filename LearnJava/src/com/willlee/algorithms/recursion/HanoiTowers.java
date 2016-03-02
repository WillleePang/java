package com.willlee.algorithms.recursion;

public class HanoiTowers {
	static int nDisks = 3;

	public static void main(String[] args) {
		doTowers(nDisks, 'a', 'b', 'c');
	}

	public static void doTowers(int topn, char from, char inter, char to) {
		if (topn == 1) {
			System.out.println("Disk 1 from " + from + " to " + to);
		} else {
			doTowers(topn - 1, from, to, inter);
			System.out.println("Disk " + topn + " from " + from + " to " + to);
			doTowers(topn - 1, inter, from, to);
		}
	}
}
