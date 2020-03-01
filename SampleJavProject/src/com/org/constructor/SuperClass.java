package com.org.constructor;

public class SuperClass {
	
	{
		System.out.println("non static block of super class");
	}
	
	SuperClass() throws Exception{
		throw new Exception();
	}
	
	SuperClass(String name){
		System.out.println("creating super class instance: "+name);
	}
}
