package com.willlee.springbootdemo.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -6565839767618439083L;
	private String useraccount;
	private String password;
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

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
