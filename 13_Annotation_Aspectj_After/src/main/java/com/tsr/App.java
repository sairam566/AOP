package com.tsr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsr.beans.KeyGenerator;
import com.tsr.config.AJavaConfig;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AJavaConfig.class);

		KeyGenerator keyGenerator = context.getBean("keyGenerator", KeyGenerator.class);

		int keySize = keyGenerator.keyGenerator(100);

		System.out.println("Generated Key : " + keySize);
	}
}
