package com.tsr.beans;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public int add(int a, int b) {
		System.out.println("Inside Add()");
		return a + b;
	}

	public int add(int a, int b, int c) {
		return a + b + c;
	}

	public int substract(int a, int b) {
		return b - a;
	}

	public int multiply(int a, int b) {
		return a * b;
	}
}
