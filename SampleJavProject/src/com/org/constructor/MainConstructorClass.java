package com.org.constructor;

public class MainConstructorClass {
	
	public static void main(String[] args) throws Exception {
		
		ConstructorOverloadExample obj = new ConstructorOverloadExample("teju");
		
		System.out.println(obj.name +","+ obj.age);
		
	}

}
