package com.tsr.aspectj;

import org.aspectj.lang.JoinPoint;

import com.tsr.beans.AuthenticationManager;
import com.tsr.exceptions.BadCredentialsException;

public class SecurityAspect {
	
	private AuthenticationManager authenticationManager;
	
	public SecurityAspect(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public void log(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		StringBuffer methodSignature = new StringBuffer();
		methodSignature.append("(");
		for (int i = 0; i < args.length; i++) {
			if(i==0) {
				methodSignature.append(args[i]);
				continue;
			}
			methodSignature.append(", "+args[i]);
		}
		methodSignature.append(")");
		
		System.out.println("Entered into "+methodName+methodSignature);
	}
	
	public void securityAudit() {
		if(!authenticationManager.authenticate()) {
			throw new BadCredentialsException("Bad Credentials : Invalid UserName/Password");
		}
	}
}
