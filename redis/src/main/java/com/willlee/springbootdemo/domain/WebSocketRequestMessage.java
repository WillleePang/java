package com.willlee.springbootdemo.domain;

public class WebSocketRequestMessage {
	private String reqestMessage;

	public WebSocketRequestMessage(String reqestMessage) {
		super();
		this.reqestMessage = reqestMessage;
	}

	public String getReqestMessage() {
		return reqestMessage;
	}
}
