package com.org.syncronize;

import java.util.concurrent.CountDownLatch;

class TestThread extends Thread{
	CountDownLatch latch;
	
	TestThread(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void run(){
		System.out.println("Executing " + Thread.currentThread().getName());
		latch.countDown();
	}
	
}

public class CountDownLatchDemo {
	
	public static void main(String[] args) throws InterruptedException{
		CountDownLatch latch = new CountDownLatch(6);
		
		TestThread t1 = new TestThread(latch);
		TestThread t2 = new TestThread(latch);
		TestThread t3 = new TestThread(latch);
		TestThread t4 = new TestThread(latch);
		TestThread t5 = new TestThread(latch);
		TestThread t6 = new TestThread(latch);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		System.out.println("Waiting for other threads to complete their execution");
		latch.await();
		System.out.println("Executing main thread after all 3 threads completion");
	}

}
