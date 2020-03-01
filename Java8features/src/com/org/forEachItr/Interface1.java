package com.org.forEachItr;

public interface Interface1 {
	
	default void log(){
		System.out.println("Interface 1 logging");
	}
	
	static void print (){
		System.out.println("Interface 1 printing");
	}
		// default and static methods can't Override object class methods
//	static String toString(){
//		
//	}
	
//	default boolean equals(Object obj){
//		return false;
//	}

}
