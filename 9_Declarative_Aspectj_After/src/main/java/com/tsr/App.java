package com.tsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsr.beans.KeyGenerator;

public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/tsr/config/application-context.xml");
		
		KeyGenerator generator = applicationContext.getBean("keyGen",KeyGenerator.class);
		
		int key = generator.generateKey(100);
		
		System.out.println("Valid Key: "+key);
	}
}
