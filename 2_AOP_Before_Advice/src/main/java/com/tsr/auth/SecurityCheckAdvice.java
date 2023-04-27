package com.tsr.auth;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityCheckAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		AuthenticationManager authenticationManager = null;
		boolean isAuthenticated = false;
		
		authenticationManager = AuthenticationManager.getInstance();
		isAuthenticated = authenticationManager.authenticate();
		if(!isAuthenticated) {
			throw new InvalidCredentials("Invalid credentials");
		}
		System.out.println("Valid Login details");
	}

}
