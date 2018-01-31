package com.willlee.innerclass.repeatmethod;

public class Rotbot implements Machine {

	public void run() {
		System.out.println("�������ܲ�");
	}

	private class humanity implements Human {
		public void run() {
			System.out.println("�����ܲ�");
		}
	}

	public Human getHumanity() {
		return new humanity();
	}

	public static void main(String[] args) {
		Rotbot robot = new Rotbot();
		robot.run();
		Human human = robot.getHumanity();
		human.run();
	}
}
