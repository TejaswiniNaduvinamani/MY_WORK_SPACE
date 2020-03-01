package com.org.syncronize;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class Shared{
	
	public static int count = 0;
}

class MyThread extends Thread {
	
	Semaphore semp;
	String threadName;
	
	MyThread(Semaphore semp, String threadName){
		this.semp = semp;
		this.threadName = threadName;
	}
	
	@Override
	public void run(){
		if(threadName.equals("A")){
			System.out.println(threadName +" Waiting for permit");
			try {
				semp.acquire();
				System.out.println(threadName + " acquired lock");
				IntStream.range(0, 5).forEach((i)-> {
					Shared.count++;
					System.out.println(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					});
				semp.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println(threadName +" Waiting for permit");
			try {
				semp.acquire();
				System.out.println(threadName + " acquired lock");
				IntStream.range(0, 5).forEach((i)-> {
					Shared.count--;
					System.out.println(threadName +": "+i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					});
				semp.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	
	
}

public class SemaphoreDemo {
	
	public static void main(String[]  args) throws InterruptedException {
		
		Semaphore semp = new Semaphore(1);
		MyThread t1 = new MyThread(semp, "A");
		MyThread t2 = new MyThread(semp, "B");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count at the end: "+ Shared.count);
		
	}

}
