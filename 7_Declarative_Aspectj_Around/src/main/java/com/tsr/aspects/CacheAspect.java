package com.tsr.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import com.tsr.beans.Cache;

public class CacheAspect {
	
	
	private Cache cache;
	
	public Object cache(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		StringBuffer methodSignature = new StringBuffer();
		methodSignature.append("(");
		for (int i = 0; i < args.length; i++) {
			if(i==0) {
				methodSignature.append(args[i]);
				continue;
			}
			methodSignature.append(","+args[i]);
		}
		methodSignature.append(")");
		
		String key = methodName+methodSignature;
		
		if(cache.conatins(key)) {
			return cache.get(key);
		}
		Object object = pjp.proceed();
		
		cache.put(key, object);
		
		return object;
		
	}

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}
}
