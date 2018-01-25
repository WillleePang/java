package com.willlee.springbootdemo.domain;

import java.io.Serializable;

public class Friend implements Serializable {

	private static final long serialVersionUID = 8741013145411182735L;

	public Friend(String nickname) {
		super();
		this.nickname = nickname;
	}

	String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
