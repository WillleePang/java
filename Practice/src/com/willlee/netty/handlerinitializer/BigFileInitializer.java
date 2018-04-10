package com.willlee.netty.handlerinitializer;

import java.io.FileInputStream;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;

public class BigFileInitializer extends ChannelInitializer<Channel> {

	@Override
	protected void initChannel(Channel ch) throws Exception {
		String file = "";
		FileInputStream in = new FileInputStream(file);
		FileRegion fileRegion = new DefaultFileRegion(in.getChannel(), 0, file.length());
		ch.writeAndFlush(fileRegion).addListener(new ChannelFutureListener() {
			public void operationComplete(ChannelFuture future) throws Exception {
				if (!future.isSuccess()) {
					Throwable cause = future.cause();
					// Do something
				}
			}
		});
	}
}
