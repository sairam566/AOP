package com.tsr.auth;

import org.springframework.aop.framework.ProxyFactory;

public class Main {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new LoanManager());
		factory.addAdvice(new SecurityCheckAdvice());
		
		AuthenticationManager authenticationManager = AuthenticationManager.getInstance();
		authenticationManager.login("sai", "ram");
		LoanManager loanManager = (LoanManager) factory.getProxy();
		loanManager.approveLoan(123);
	}
}
