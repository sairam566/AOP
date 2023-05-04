package com.tsr;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.tsr.staticpc.Calculator;
import com.tsr.staticpc.LoggingAdvice;
import com.tsr.staticpc.LoggingStaticPointCut;

public class App 
{
    public static void main( String[] args )
    {
        ProxyFactory factory = new ProxyFactory();
        
        factory.setTarget(new Calculator());
        
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new LoggingStaticPointCut(), new LoggingAdvice());
        
        factory.addAdvisor(advisor);
        
        Calculator cal = (Calculator) factory.getProxy();
        
        int add = cal.add(10, 20);
        System.out.println("Sum = "+add);
        
        int mul = cal.multiply(10, 20);
        System.out.println("Multiply = "+mul);
    }
}
