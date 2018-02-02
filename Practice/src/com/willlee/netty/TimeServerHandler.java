package com.willlee.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelActive(final ChannelHandlerContext context) {
		final ByteBuf time = context.alloc().buffer(4);
		time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

		final ChannelFuture f = context.writeAndFlush(time);
		f.addListener(new ChannelFutureListener() {
			public void operationComplete(ChannelFuture future) {
				assert f == future;
				context.close();
			}
		});
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
		cause.printStackTrace();
		context.close();
	}
}
