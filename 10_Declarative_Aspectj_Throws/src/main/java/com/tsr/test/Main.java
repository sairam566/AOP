package com.tsr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tsr.beans.ThrowsException;

public class Main {

	public static void main(String... args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/tsr/config/application-context.xml");
		
		ThrowsException exception = applicationContext.getBean("exception",ThrowsException.class);
		exception.throwException(4);
	}
}
