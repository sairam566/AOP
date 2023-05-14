package com.tsr.aspectj;

import org.aspectj.lang.JoinPoint;

public class GlobalExceptionAspect {

	public void logException(JoinPoint joinPoint, IllegalArgumentException exception) {
		System.out.println("Global Exception : "+exception.getMessage());
	}
}
