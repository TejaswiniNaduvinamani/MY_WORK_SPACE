package com.org.constructor;

import java.util.concurrent.TimeUnit;

public class MainClassMethodOverride {
	
	public static void main(String[] args) throws Exception {
		MethodOverrideExapmle obj = new MethodOverriddingClass();
		obj.overriddenMethod(); // Child method overrides super class method
		obj.overriddenMethodForStatic(); // No overriding happens
		
		System.out.println(TimeUnit.SECONDS.toMillis(30));
	}

}
