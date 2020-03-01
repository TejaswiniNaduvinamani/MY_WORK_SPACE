package com.org.constructor;

public class MethodOverrideExapmle {

	public void overriddenMethod() {
		System.out.println("Super class method ");
	}

	public static void overriddenMethodForStatic() {
		System.out.println("Super class static method ");
	}

}

class MethodOverriddingClass extends MethodOverrideExapmle {

	@Override
	public void overriddenMethod() {
		System.out.println("child class method ");
	}

	public static void overriddenMethodForStatic() {
		System.out.println("child class static method ");
	}

}
