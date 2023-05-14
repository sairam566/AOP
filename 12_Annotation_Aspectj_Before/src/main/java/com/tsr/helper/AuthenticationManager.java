package com.tsr.helper;


public class AuthenticationManager {

	private static AuthenticationManager authenticationManager = null;

	private ThreadLocal<UserCredentials> threadLocal = null;

	private AuthenticationManager() {
		threadLocal = new ThreadLocal<UserCredentials>();
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

	public boolean isAuthenticated() {
		UserCredentials credentials = threadLocal.get();
		if ("sai".equals(credentials.getUserName()) && "ram".equals(credentials.getPassword())) {
			return true;
		}
		return false;
	}
}
