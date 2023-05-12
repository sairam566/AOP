package com.tsr.aspects;

import org.aspectj.lang.JoinPoint;

public class ValidateKeyAspect {
	
	public void validateKey(JoinPoint joinPoint,Object returnVal) {
		if((int)returnVal < 50 ) {
			throw new IllegalArgumentException("Key size is "+returnVal);
		}
	}
}
