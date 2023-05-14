package com.tsr.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsr.helper.AuthenticationManager;
import com.tsr.helper.InvalidCredentials;

@Component
@Aspect
public class AuditAspect {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Before("within(com.tsr.beans.*)")
	public void audit(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("Entered into "+methodName);
	}
	
	@Before("within(com.tsr.beans.*)")
	public void authorize(JoinPoint jp) {
		if(!authenticationManager.isAuthenticated()) {
			throw new InvalidCredentials("Invalid Credentials");
		}
	}
}
