package com.tsr.dynamicpc;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class LoggingDynamicPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if (targetClass == Calculator.class && method.getName().equals("add")) {
			if((int)args[0]>100 && (int)args[1]>100) {
				return true;
			}
		}
		return false;
	}

}
