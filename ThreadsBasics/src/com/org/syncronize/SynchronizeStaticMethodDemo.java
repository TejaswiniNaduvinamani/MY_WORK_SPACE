package com.org.syncronize;

class TestDemo{
	
	synchronized public static void test(){
		for(int i =0; i<10; i++){
			System.out.println("Executing from Static : "+ Thread.currentThread().getName());
		}
	}
	
	synchronized public  void testNonStatic(){
		for(int i =0; i<10; i++){
			System.out.println("Executing from NonStatic : "+ Thread.currentThread().getName());
		}
	}
	
}



public class SynchronizeStaticMethodDemo {
	
	public static void main(String[] args){
		TestDemo obj = new TestDemo();
		TestDemo obj2 = new TestDemo();
		Thread t1 = new Thread(() -> {obj.test(); obj.testNonStatic();});
		Thread t2 = new Thread(() -> {obj.testNonStatic(); obj.test(); });
		t1.start();
		t2.start();
		
		System.out.println("Processor : " + Runtime.getRuntime().availableProcessors());
	}

}
