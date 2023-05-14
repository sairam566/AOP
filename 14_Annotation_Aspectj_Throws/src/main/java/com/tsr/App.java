package com.tsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsr.beans.ThrowException;
import com.tsr.config.AJavaConfig;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AJavaConfig.class);
    	
    	ThrowException exception = context.getBean("throwException",ThrowException.class);
    	
    	exception.throwException(4);
    }
}
