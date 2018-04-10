package com.willlee.netty.logevent;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, LogEvent event) throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append(event.getReceive()).append("[").append(event.getSource().toString()).append("] [")
				.append(event.getLogfile()).append("] : ").append(event.getMsg());
		System.out.println(builder.toString());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
