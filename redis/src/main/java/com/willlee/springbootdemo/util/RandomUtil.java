package com.willlee.springbootdemo.util;

import java.util.UUID;

public class RandomUtil {
	public static String getUUID() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString();
	}
}
