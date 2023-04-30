package com.tsr.keygen;

import java.security.SecureRandom;

public class KeyGenerator {
	
	public int generateKey() {
		SecureRandom random = new SecureRandom();
		return random.nextInt(100);
	}
}
