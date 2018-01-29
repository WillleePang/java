package com.willlee.springbootdemo.domain;

public class WebSocketResponseMessage {
	private String responseMessage;

	public WebSocketResponseMessage(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
}
