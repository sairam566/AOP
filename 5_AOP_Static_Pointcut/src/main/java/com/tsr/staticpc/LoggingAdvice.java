package com.tsr.staticpc;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName = invocation.getMethod().getName();
		Object[] methodArguments = invocation.getArguments();
		Object returnVal = null;
		
		System.out.print("Entered into "+methodName+"(");
		for (int i = 0; i < methodArguments.length; i++) {
			if(i==0) {
				System.out.print(methodArguments[i]);
				continue;
			}
			System.out.print(", "+methodArguments[i]);
		}
		System.out.println(")");
		
		returnVal = invocation.proceed();
		
		System.out.println("Exited out of "+methodName+" with return value =: "+returnVal);
		
		return returnVal;
	}

}
