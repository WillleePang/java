package com.willlee.netty.handlerinitializer;

import java.io.Serializable;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;

/**
 * 使用jboss marshalling进行序列化
 * 
 * @author hq
 *
 */
public class MarshallingInitializer extends ChannelInitializer<Channel> {

	private final MarshallerProvider marshallerProvider;
	private final UnmarshallerProvider unmarshallerProvider;

	public MarshallingInitializer(MarshallerProvider marshallerProvider, UnmarshallerProvider unmarshallerProvider) {
		super();
		this.marshallerProvider = marshallerProvider;
		this.unmarshallerProvider = unmarshallerProvider;
	}

	public MarshallerProvider getMarshallerProvider() {
		return marshallerProvider;
	}

	public UnmarshallerProvider getUnmarshallerProvider() {
		return unmarshallerProvider;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new MarshallingDecoder(unmarshallerProvider));
		pipeline.addLast(new MarshallingEncoder(marshallerProvider));
		pipeline.addLast(new ObjectHandler());
	}

	public static final class ObjectHandler extends SimpleChannelInboundHandler<Serializable> {
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, Serializable msg) throws Exception {
			// Do something
		}
	}

}
