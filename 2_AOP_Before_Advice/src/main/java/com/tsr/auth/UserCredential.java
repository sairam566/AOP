package com.tsr.auth;

public class UserCredential {
	private String userName;
	private String password;
	
	public UserCredential() {
		super();
	}

	public UserCredential(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredential [userName=" + userName + ", password=" + password + "]";
	}
	
}
