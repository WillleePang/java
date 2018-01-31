package com.willlee.newio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {
	private ServerSocket socket = null;

	public PlainOioServer(int port) {
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void serve() throws IOException {
		try {
			while (true) {
				final Socket clientSocket = socket.accept();
				System.out.println("Accepted connection from " + clientSocket);
				new Thread(new Runnable() {

					public void run() {
						OutputStream out;
						try {
							out = clientSocket.getOutputStream();
							out.write("Hi!\r\n".getBytes(Charset.forName("utf-8")));
							out.flush();
							clientSocket.close();
						} catch (Exception e) {
							e.printStackTrace();
							try {
								clientSocket.close();
							} catch (Exception e2) {
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
