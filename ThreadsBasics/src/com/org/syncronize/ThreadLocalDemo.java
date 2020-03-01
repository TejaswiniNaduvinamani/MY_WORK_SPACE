package com.org.syncronize;

import java.util.concurrent.atomic.AtomicInteger;

class TheadLocalTest implements Runnable {
	
	public   AtomicInteger  nextId   = new AtomicInteger(0);
	
	public ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			return nextId.getAndIncrement();
		}
	};
	
//	public Integer threadId = nextId.incrementAndGet();
	
	@Override
	public void run() {
		try {
			System.out.println("Execution started for thread : "+Thread.currentThread().getName() + ", "+ threadId.get());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Execution ended for thread : "+Thread.currentThread().getName() + ", "+ threadId.get());
	}
	
	
	
}

public class ThreadLocalDemo {
	
	public static void main(String[] args) {
		TheadLocalTest threadTest = new TheadLocalTest();
		Thread t1 = new Thread(threadTest);
		Thread t2 = new Thread(threadTest);
		Thread t3 = new Thread(threadTest);
		t1.start();
		t2.start();
		t3.start();
//		TheadLocalTest.threadId.remove();
	}

}
