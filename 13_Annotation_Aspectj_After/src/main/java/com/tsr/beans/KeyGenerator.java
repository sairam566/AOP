package com.tsr.beans;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class KeyGenerator {
	
	public int keyGenerator(int lenght) {
		SecureRandom random = new SecureRandom();
		return random.nextInt(lenght);
	}
}
