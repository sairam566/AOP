package com.tsr.audit;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AuditAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String methodName = method.getName();
		StringBuffer sb = new StringBuffer();
		sb.append(methodName+"(");
		for (int i = 0; i < args.length; i++) {
			if(i==0) {
				sb.append(args[i]);
				continue;
			}
			sb.append(","+args[i]);
		}
		sb.append(")");
		System.out.println(sb.toString());
	}

}
