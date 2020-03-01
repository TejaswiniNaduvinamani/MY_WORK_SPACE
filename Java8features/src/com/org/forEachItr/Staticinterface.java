package com.org.forEachItr;

public class Staticinterface implements MyDataInterface{
	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	public static void main(String args[]){
		Staticinterface obj = new Staticinterface();
		obj.print("");
		obj.isNull("abc");
	}

}
