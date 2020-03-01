package com.org.forEachItr;

public class DefaultStaticInterface implements Interface1, Interface2{
	
	public static void main(String[] args){
//		Interface2 i2 = () -> { System.out.println("Printing from method2 of interface 2"); };
		DefaultStaticInterface obj = new DefaultStaticInterface();
		obj.log();
		
		
		
		
	}

	@Override
	public void log() {
//		Interface2.super.log();
		System.out.println("Overided log");
	}

}
