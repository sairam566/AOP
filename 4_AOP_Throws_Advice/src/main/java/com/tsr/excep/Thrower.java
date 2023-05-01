package com.tsr.excep;

public class Thrower {
	public int willThrow(int i) {
		if(i<0) {
			throw new IllegalArgumentException();
		}
		return i;
	}
}
