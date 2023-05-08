package com.tsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsr.beans.Calculator;

public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/tsr/conf/spring-context.xml");

		Calculator calculator = applicationContext.getBean("cal", Calculator.class);

		int sum1 = calculator.add(10, 20);
		System.out.println("Sum : " + sum1);

		int sum2 = calculator.add(10, 21);
		System.out.println("Sum : " + sum2);

		int sub = calculator.substract(10, 20);
		System.out.println("Substraction : " + sub);
	}
}
