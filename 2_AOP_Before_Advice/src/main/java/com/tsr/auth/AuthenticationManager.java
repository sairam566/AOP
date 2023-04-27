package com.tsr.auth;

public class AuthenticationManager {
	
	private static AuthenticationManager manager;
	private ThreadLocal<UserCredential> threadLocal;
	
	private AuthenticationManager() {
		super();
		threadLocal = new ThreadLocal<UserCredential>();
	}
	
	public static synchronized AuthenticationManager getInstance() {
		if(manager==null) {
			manager = new AuthenticationManager();
		}
		return manager;
	}
	
	public void login(String userName,String password) {
		threadLocal.set(new UserCredential(userName, password));
	}
	
	public void logout() {
		threadLocal.set(null);
	}
	
	public boolean authenticate() {
		if(threadLocal!=null) {
			UserCredential credential = threadLocal.get();
			if(credential!=null) {
				if(credential.getUserName().equals("sai") && credential.getPassword().equals("ram")) {
					return true;
				}
			}
		}
		return false;
	}
}
