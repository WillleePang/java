package com.willlee.innerclass.repeatmethod;

public class Rotbot implements Machine {

	@Override
	public void run() {
		System.out.println("机器人跑步");
	}

	private class humanity implements Human {
		@Override
		public void run() {
			System.out.println("人类跑步");
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
