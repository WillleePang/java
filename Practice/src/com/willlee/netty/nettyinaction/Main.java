package com.willlee.netty.nettyinaction;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class Main {
	public static void main(String[] args) {
		ByteBuf buffer = Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8);
		for (int i = 0; i < buffer.capacity(); i++) {
			byte b = buffer.getByte(i);
			System.out.println((char) b);
		}
		if (buffer.isReadable()) {
			System.out.println(buffer.readableBytes());
		}
		if (buffer.isWritable()) {
			System.out.println(buffer.writableBytes());
		}

		ByteBuf slice = buffer.slice(0, 10);
		for (int i = 0; i < slice.capacity(); i++) {
			byte b = slice.getByte(i);
			System.out.print((char) b);
		}
		System.out.println();
		buffer.setByte(0, 'J');
		for (int i = 0; i < slice.capacity(); i++) {
			byte b = slice.getByte(i);
			System.out.print((char) b);
		}
	}
}
