package com.tsr;

import org.springframework.aop.framework.ProxyFactory;

import com.tsr.keygen.KeyGenerator;
import com.tsr.keygen.SecurityAdvice;

public class App 
{
    public static void main( String[] args )
    {
    	ProxyFactory factory = new ProxyFactory();
    	factory.setTarget(new KeyGenerator());
    	factory.addAdvice(new SecurityAdvice());
    	
    	KeyGenerator generator = (KeyGenerator) factory.getProxy();
    	System.out.println(generator.generateKey());
    }
}
