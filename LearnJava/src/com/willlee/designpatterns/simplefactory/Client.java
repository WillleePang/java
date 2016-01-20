package com.willlee.designpatterns.simplefactory;

public class Client {
	public static void main(String[] args) throws Exception {
		IMusic music = MusicFactory.createMusic("com.willlee.designpatterns.simplefactory.PianoMusic");
		music.play();
	}
}
