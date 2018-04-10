package com.willlee.netty.websocketchartroom;

import javax.net.ssl.SSLEngine;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

public class SecureWebsocketChatServerInitializer extends WebsocketChatServerInitializer {
	private final SslContext context;
	private final ChannelGroup group;

	public SecureWebsocketChatServerInitializer(SslContext context, ChannelGroup group) {
		super();
		this.context = context;
		this.group = group;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		super.initChannel(ch);
		SSLEngine newEngine = context.newEngine(ch.alloc());
		newEngine.setUseClientMode(false);
		ch.pipeline().addFirst(new SslHandler(newEngine));
	}
}
