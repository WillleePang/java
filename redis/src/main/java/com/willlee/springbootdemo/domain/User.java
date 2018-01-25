package com.willlee.springbootdemo.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -6565839767618439083L;
	private String userId;
	private String nickname;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
