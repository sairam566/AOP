package com.tsr.excep;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class GlobalExceptionLogging implements ThrowsAdvice{
	
	public void afterThrowing(IllegalArgumentException ex) {
		System.out.println("2: "+ex);
	}
	
	public void afterThrowing(Method method, Object[] args, Object target, IllegalArgumentException ex) {
		System.out.println("Method Name: "+method.getName());
		System.out.println("Throws the following Exception: "+ex);
	}
}
