package com.willlee.designpatterns.simplefactory;

public class MusicFactory {
	public static IMusic createMusic(String name) throws Exception {
		return (IMusic) Class.forName(name).newInstance();
	}
}
