package com.tsr.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		
		System.out.print("Entered into the method "+methodName+"(");
		for (int i = 0; i < args.length; i++) {
			if(i==0) {
				System.out.print(args[i]);
				continue;
			}
			System.out.print(","+args[i]);
		}
		System.out.println(")");
		
		Object retObject = pjp.proceed();
		
		System.out.println("Exiting out of the method "+methodName+" with return value: "+retObject);
		
		return retObject;
				
	}
}
