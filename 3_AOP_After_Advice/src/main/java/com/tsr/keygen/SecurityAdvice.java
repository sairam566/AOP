package com.tsr.keygen;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SecurityAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		int keySize = (int) returnValue;
		if (keySize < 50) {
			throw new WeakKeyException("Weak Key size less than " + keySize + " generated");
		}
	}

}
