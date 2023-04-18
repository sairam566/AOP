package com.tsr.logs;

import org.springframework.aop.framework.ProxyFactory;

public class App 
{
    public static void main( String[] args )
    {
    	ProxyFactory proxyFactory = new ProxyFactory();
    	proxyFactory.setTarget(new Calculator());
    	proxyFactory.addAdvice(new LoggingAdvice());
    	Calculator calculator = (Calculator) proxyFactory.getProxy();
    	int val = calculator.add(10, 20);
    	System.out.println("Result is: "+val);
    }
}
