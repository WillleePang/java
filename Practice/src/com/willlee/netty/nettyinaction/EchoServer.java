package com.willlee.netty.nettyinaction;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	private final int port;

	public EchoServer(int port) {
		this.port = port;
	}

	public void start() throws Exception {
		NioEventLoopGroup group = new NioEventLoopGroup();// 创建EventLoopGroup
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(group)// 创建ServerBootstrap
					.channel(NioServerSocketChannel.class)// 指定使用NIO的传输Channel
					.localAddress(new InetSocketAddress(port))// 设置socket地址使用所选的端口
					.childHandler(new ChannelInitializer<SocketChannel>() {// 添加EchoServerHandler到Channel的ChannelPipeline
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new EchoServerHandler());
						}
					});
			ChannelFuture future = serverBootstrap.bind().sync();// 绑定的服务器，sync等待服务器关闭
			System.out
					.println(EchoServer.class.getName() + " started and listen on " + future.channel().localAddress());
			future.channel().closeFuture().sync();// 关闭channel和块，直到它被关闭
		} finally {
			group.shutdownGracefully().sync();// 关机的EventLoopGroup，释放所有资源。
		}
	}

	public static void main(String[] args) throws Exception {
		new EchoServer(8080).start();
	}
}
