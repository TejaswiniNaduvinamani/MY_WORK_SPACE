package com.demo.sample;

 class B {
	
	protected void print(){
		System.out.println("B");
	}

}
 
 
 public class ClassA extends B{
	
	 public static void main(String[] args){
		 B b = new B();
		 b.print();
		 ClassA a = new ClassA();
		 a.print();
	 }
 }
