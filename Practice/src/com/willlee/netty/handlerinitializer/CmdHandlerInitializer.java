package com.willlee.netty.handlerinitializer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.LineBasedFrameDecoder;


/**
 * 处理自定义分割符的帧
 * @author hq
 *
 */
public class CmdHandlerInitializer extends ChannelInitializer<Channel> {
	final static byte SPACE = (byte) ' ';

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new CmdDecoder(64 * 1024));
		pipeline.addLast(new CmdHandler());
	}

	public static final class Cmd {
		private final ByteBuf name;
		private final ByteBuf args;

		public Cmd(ByteBuf name, ByteBuf args) {
			super();
			this.name = name;
			this.args = args;
		}

		public ByteBuf getName() {
			return name;
		}

		public ByteBuf getArgs() {
			return args;
		}
	}

	public static final class CmdDecoder extends LineBasedFrameDecoder {

		public CmdDecoder(int maxLength) {
			super(maxLength);
		}

		@Override
		protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
			ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
			if (frame == null) {
				return null;
			}

			int index = frame.indexOf(frame.readableBytes(), frame.writableBytes(), SPACE);
			return new Cmd(frame.slice(frame.readableBytes(), index), frame.slice(index + 1, frame.writableBytes()));
		}
	}

	public static final class CmdHandler extends SimpleChannelInboundHandler<Cmd> {
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, Cmd msg) throws Exception {
			// Do something with the command
		}
	}
}
