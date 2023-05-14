package com.tsr.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KeyCheckAspect {
	
	@AfterReturning(value = "within(com.tsr.beans.*)",returning = "returnVal")
	public void check(JoinPoint jp,Object returnVal) {
		if((int) returnVal<50) {
			throw new IllegalArgumentException("Generated key value is less than recommended size");
		}
	}
}
