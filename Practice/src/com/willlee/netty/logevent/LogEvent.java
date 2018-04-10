package com.willlee.netty.logevent;

import java.net.InetSocketAddress;

public class LogEvent {
	public static final byte SEPARATOR = (byte) ':';
	private final InetSocketAddress source;
	private final String logfile;
	private final String msg;
	private final long receive;

	public LogEvent(String logfile, String msg) {
		this(null, -1, logfile, msg);
	}

	public LogEvent(InetSocketAddress source, long receive, String logfile, String msg) {
		this.source = source;
		this.logfile = logfile;
		this.msg = msg;
		this.receive = receive;
	}

	public static byte getSeparator() {
		return SEPARATOR;
	}

	public InetSocketAddress getSource() {
		return source;
	}

	public String getLogfile() {
		return logfile;
	}

	public String getMsg() {
		return msg;
	}

	public long getReceive() {
		return receive;
	}

}
