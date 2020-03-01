package com.org.syncronize;

import java.util.concurrent.Semaphore;

class PrintClass extends Thread{
	
	Semaphore semp;
	String threadName;
	public static int count = 0;
	
	PrintClass(Semaphore semp, String threadName){
		this.semp = semp;
		this.threadName = threadName;
	}
	
	@Override
	public void run(){
		if(threadName.equals("A") ){
			while(true){
				try {
					if(count==0){
						semp.acquire();
						System.out.println(count);
						count++;
						Thread.sleep(100);
					} else{
						semp.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
		}
		else{
			while(true){
				try {
					if(count==1){
						semp.acquire();
						System.out.println(count);
						count--;
						Thread.sleep(100);
					} else{
						semp.release();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			}
	}
	
	
}
	
//	public void printZero() throws InterruptedException{
//		while(true){
//		synchronized (this) {
//			System.out.println("0");
//			count++;
//			if(count==1){
//				wait();
//			}
//			else 
//				notify();
//		}
//		}
//	}
//	
//	public void printOne() throws InterruptedException{
//		while(true){
//		synchronized (this) {
//			System.out.println("1");
//			count--;
//			if(count==0){
//				notify();
//			}else
//				wait();
//		}
//		}
//	}


public class PrintZeroOneInfiniteUsingTwoThreads {
	
	static class Thread1 implements Runnable{
		
		Semaphore semA;
		Semaphore semB;
		int val;
		
		public Thread1(Semaphore semA,Semaphore semB,int val){
			this.semA = semA;
			this.semB = semB;
			this.val = val;
		}
		
		@Override
		public void run() {
			
			try {
				while(true){
				semA.acquire();
				System.out.println(val);
				semB.release();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		Semaphore semp = new Semaphore(1);
		System.out.println(semp.toString());
		PrintClass print1 = new PrintClass(semp, "A");
		PrintClass print2 = new PrintClass(semp, "B");
		Semaphore sempA = new Semaphore(1);
		Semaphore sempB = new Semaphore(0);
		Thread t = new Thread(new Thread1(sempA,sempB,0));
		Thread j = new Thread(new Thread1(sempB,sempA,1));
		t.start();
		j.start();
		t.join();
//		PrintClass print = new PrintClass();
//		Thread t1 = new Thread(()->{
//			try {
//				print.printZero();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		});
//		Thread t2 = new Thread(()->{
//			try {
//				print.printOne();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		});
//		
//		t1.start();
//		t2.start();
//		print1.start();
//		print2.start();
//		
//		print1.join();
//		print2.join();
//		
	}

}
