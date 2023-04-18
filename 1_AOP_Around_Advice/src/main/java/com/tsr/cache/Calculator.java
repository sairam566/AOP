package com.tsr.cache;

public class Calculator {
	int add(int a,int b) {
		int sum = 0;
		System.out.println("In Add");
		sum = a + b; // costly operation So we need to apply cache Mechanism.
		return sum;
	}
}
