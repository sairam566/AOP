package com.tsr.both.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName = invocation.getMethod().getName();
		Object[] args = invocation.getArguments();
		
		StringBuffer sb = new StringBuffer();
		sb.append("Entered into "+methodName+"(");
		for(int i=0;i<args.length;i++) {
			if(i==0) {
				sb.append(args[i]);
				continue;
			}
			sb.append(","+args[i]);
		}
		sb.append(")");
		
		System.out.println(sb);
		
		Object object = invocation.proceed();
		System.out.println("Exiting from "+methodName+" with return value: "+object);
		
		return object;
	}

}
