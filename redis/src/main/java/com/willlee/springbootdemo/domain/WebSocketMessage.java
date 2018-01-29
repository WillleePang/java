package com.willlee.springbootdemo.domain;

public class WebSocketMessage {
	private String useraccount;
	private String message;
	private String headicon;

	public WebSocketMessage() {
		super();
	}

	public WebSocketMessage(String useraccount, String message) {
		super();
		this.useraccount = useraccount;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getHeadicon() {
		return headicon;
	}

	public void setHeadicon(String headicon) {
		this.headicon = headicon;
	}

}
