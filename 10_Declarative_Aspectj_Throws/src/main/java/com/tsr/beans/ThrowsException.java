package com.tsr.beans;

public class ThrowsException {
	
	public int throwException(int value) {
		if(value<5) {
			throw new IllegalArgumentException("Value is less than 5");
		}
		return value;
	}
}
