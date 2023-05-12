package com.tsr.beans;

import java.security.SecureRandom;

public class KeyGenerator {
	
	public int generateKey(int range) {
		SecureRandom random = new SecureRandom();
		int key = random.nextInt(range);
		return key;
	}
}
