package com.tsr.both.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName = invocation.getMethod().getName();
		Object[] args = invocation.getArguments();
		Cache cache = Cache.getInstance();
		
		StringBuffer methodSignature = new StringBuffer();
		methodSignature.append("(");
		for(int i=0;i<args.length;i++) {
			if(i==0) {
				methodSignature.append(args[i]);
				continue;
			}
			methodSignature.append(","+args[i]);
		}
		methodSignature.append(")");
		
		String key = methodName+methodSignature;
		System.out.println(key);
		
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		Object object = invocation.proceed();
		
		cache.put(key, object);
		
		return object;
	}

}
