package com.tsr.both.advice;

import org.springframework.aop.framework.ProxyFactory;

import com.tsr.cache.CacheAdvice;

public class App {
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		
		proxyFactory.setTarget(new Calculator());
		
		/*
		 * In which order we add addAdvice() in that same order only
		 * they apply on the Target class
		 */
		proxyFactory.addAdvice(new CacheAdvice());
		proxyFactory.addAdvice(new LoggingAdvice());
		
		Calculator calculator = (Calculator) proxyFactory.getProxy();
		
		int val1 = calculator.add(10, 20);
		System.out.println("Result: "+val1);
		int val2 = calculator.add(10, 20);
		System.out.println("Result: "+val2);
	}
}
