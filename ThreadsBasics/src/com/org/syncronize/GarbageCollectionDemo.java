package com.org.syncronize;

public class GarbageCollectionDemo {
	
	
	public static void main(String[] args){
		GarbageCollectionDemo obj = new GarbageCollectionDemo();
		obj = null;
		System.gc();
		
		
		
	}
	
	@Override
	protected void finalize() throws Throwable{
		System.out.println("Garbage Collection Started");
		int i = 10/0;
		System.out.println("Executing even after the Exception");

	}

}
