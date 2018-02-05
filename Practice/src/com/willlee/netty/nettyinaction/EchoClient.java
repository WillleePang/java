package com.willlee.netty.nettyinaction;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {
	private final String host;
	private final int port;

	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void start() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();// 指定EventLoopGroup来处理客户端事件。由于我们使用NIO传输，所以用到了NioEventLoopGroup的实现
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)// 使用的channel类型是一个用于NIO传输
					.remoteAddress(new InetSocketAddress(host, port))// 设置服务器的InetSocketAddress
					.handler(new ChannelInitializer<SocketChannel>() {// 当建立一个连接和一个新的通道时，创建添加到EchoClientHandler实例到pipeline
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new EchoClientHandler());
						}
					});
			ChannelFuture f = b.connect().sync();// 连接到远程;等待连接完成
			f.channel().close().sync();// 阻塞直到Channel关闭
		} finally {
			group.shutdownGracefully().sync();// 调用shutdownGracefully()来关闭线程池和释放所有资源
		}
	}

	public static void main(String[] args) throws Exception {
		final String host = "127.0.0.1";
		final int port = 8080;
		new EchoClient(host, port).start();
	}
}
