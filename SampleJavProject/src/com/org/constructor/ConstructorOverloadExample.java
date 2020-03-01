package com.org.constructor;

public class ConstructorOverloadExample extends SuperClass{
	
	 String name ;
	 int age;
	
	 {
		 System.out.println("non static block");
	 }
	
	ConstructorOverloadExample(String name) throws Exception {
		super();
		this.name = name;
		System.out.println("creating child class instance");
	}
	
	ConstructorOverloadExample(String name, int age) {
		super(name);
		this.age = age;
	}

}
