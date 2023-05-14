package com.tsr.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {
	
	@Around("execution(* com.tsr.beans.Calculator.add(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

		String methodName = joinPoint.getSignature().getName();

		Object[] args = joinPoint.getArgs();

		StringBuffer methodSignature = new StringBuffer();
		methodSignature.append("(");
		for (int i = 0; i < args.length; i++) {
			if (i == 0) {
				methodSignature.append(args[i]);
				continue;
			}
			methodSignature.append(", " + args[i]);
		}
		methodSignature.append(")");

		System.out.println("Entered into " + methodName + methodSignature);

		Object returnVal = joinPoint.proceed();

		System.out.println("Exiting out of " + methodName + methodSignature + " with return value: " + returnVal);

		return returnVal;
	}
}
