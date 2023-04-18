package com.tsr.cache;

import org.springframework.aop.framework.ProxyFactory;

public class App {

	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new Calculator());
		factory.addAdvice(new CacheAdvice());
		
		Calculator calculator = (Calculator) factory.getProxy();
		System.out.println(calculator.add(10, 20));// calculation is performed
		System.out.println(calculator.add(10, 20));// from cache
		System.out.println(calculator.add(20, 20));// calculation is performed
		System.out.println(calculator.add(20, 20));// from cache
	}

}
