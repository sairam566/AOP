package com.tsr.beans;

import org.springframework.stereotype.Component;

@Component
public class ThrowException {
	
	public void throwException(int value) {
		if(value<5) {
			throw new IllegalArgumentException("Value is less than 5");
		}
	}
}
