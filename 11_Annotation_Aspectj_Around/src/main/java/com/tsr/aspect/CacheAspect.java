package com.tsr.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tsr.helper.Cache;

@Component
@Aspect
@Order(1)
public class CacheAspect {

	@Autowired
	private Cache cache;

	@Around("execution(* com.tsr.beans.Calculator.add(..))")
	public Object applyCache(ProceedingJoinPoint joinPoint) throws Throwable {
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
		
		String key = methodName+methodSignature;
		
		if(cache.containsKey(key)) {
			return cache.get(key);
		}
		
		Object returnVal = joinPoint.proceed();
		
		cache.add(key, returnVal);
		
		return returnVal;
	}
}
