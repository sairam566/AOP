package com.tsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsr.beans.Calculator;
import com.tsr.config.AAJavaConfig;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AAJavaConfig.class);
        
        Calculator calculator = applicationContext.getBean("calculator",Calculator.class);
        
        int sum = calculator.add(10, 20);
        System.out.println("Sum "+sum);
        
        int sum1 = calculator.add(10, 20);
        System.out.println("Sum "+sum1);
    }
}
