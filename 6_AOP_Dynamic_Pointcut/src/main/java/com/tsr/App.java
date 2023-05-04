package com.tsr;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.tsr.dynamicpc.Calculator;
import com.tsr.dynamicpc.LoggingAdvice;
import com.tsr.dynamicpc.LoggingDynamicPointcut;

public class App 
{
    public static void main( String[] args )
    {
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new Calculator());
        
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new LoggingDynamicPointcut(), new LoggingAdvice());
        
        factory.addAdvisor(advisor);
        
        Calculator calculator = (Calculator) factory.getProxy();
        
        int sum1 = calculator.add(20, 30); // No logging is performed

        int sum2 = calculator.add(101, 234); // Logging is performed because values are greater than 100
        
        
    }
}
