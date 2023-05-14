package com.tsr.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GolbalExceptionAspect {

	@AfterThrowing(value = "within(com.tsr.beans.*)", throwing = "exception")
	public void logException(JoinPoint joinPoint, IllegalArgumentException exception) {
		System.out.println("Method "+joinPoint.getSignature().getName()+" thrown an exception with message "+exception.getMessage());
	}
}
