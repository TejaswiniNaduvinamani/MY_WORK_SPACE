package com.org.syncronize;

class TheadLocalTest2 implements Runnable {
	static int init;
	TheadLocalTest2(int i) {
		this.init = i;
	}
	static ThreadLocal<Integer> initVal = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return init;
		}
	};
	@Override
	public void run() {
		System.out.println("Printing from Thread : " + Thread.currentThread().getId() + ", " + initVal.get());
		try {
			Thread.sleep(1000);
			System.out.println("Printing ended from Thread : " + Thread.currentThread().getId() + ", " + initVal.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// This will not work as we are passing 2 different objects 
//Thread local comes into picture when Single object is shared between multiple threads
// And each value generated in thread is local to that thread only
public class ThreadLocalDemo2 {
	
	public static void main(String[] args) throws InterruptedException {
		TheadLocalTest2 test1 = new TheadLocalTest2(1);
		TheadLocalTest2 test2 = new TheadLocalTest2(2);
		Thread t1 = new Thread(test1);
		Thread.sleep(500);
		Thread t2 = new Thread(test2);
		t1.start();
		t2.start();
	}

}
