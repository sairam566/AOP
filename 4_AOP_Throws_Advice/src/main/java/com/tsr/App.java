package com.tsr;

import org.springframework.aop.framework.ProxyFactory;

import com.tsr.excep.GlobalExceptionLogging;
import com.tsr.excep.Thrower;

public class App 
{
    public static void main( String[] args )
    {
    	ProxyFactory factory = new ProxyFactory();
    	factory.setTarget(new Thrower());
    	factory.addAdvice(new GlobalExceptionLogging());
    	
    	Thrower thrower = (Thrower) factory.getProxy();
    	int x = thrower.willThrow(-1);
    	System.out.println(x);
    }
}
