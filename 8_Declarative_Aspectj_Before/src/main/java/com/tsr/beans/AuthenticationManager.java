package com.tsr.beans;

public class AuthenticationManager {

	private static AuthenticationManager authenticationManager;
	private ThreadLocal<UserCredentials> threadLocal;

	private AuthenticationManager() {
		this.threadLocal = new ThreadLocal<UserCredentials>();
	}

	public static synchronized AuthenticationManager getInstance() {
		if (authenticationManager == null) {
			authenticationManager = new AuthenticationManager();
		}
		return authenticationManager;
	}

	public void login(String userName, String password) {
		threadLocal.set(new UserCredentials(userName, password));
	}

	public void logout() {
		threadLocal.set(null);
	}

	public boolean authenticate() {
		UserCredentials credentials = threadLocal.get();
		if (credentials.getUserName().equals("sai") && credentials.getPassword().equals("TSR")) {
			return true;
		}
		return false;
	}
	
	public String loggedInUser() {
		UserCredentials credentials = threadLocal.get();
		return credentials.getUserName();
	}
}
