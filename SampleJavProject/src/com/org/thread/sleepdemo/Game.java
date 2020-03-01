package com.org.thread.sleepdemo;

public class Game implements Runnable{
	private volatile boolean isStopped = false; 
	@Override
	public void run() { 
		while(!isStopped){
			System.out.println("Game thread is running....."); 
			System.out.println("Game thread is now going to pause by "+ Thread.currentThread().getName()); 
			try { 
				Thread.sleep(200); 
				} catch (InterruptedException e) { 
					e.printStackTrace(); 
					} 
			System.out.println("Game thread is now resumed by.."+ Thread.currentThread().getName());
			} 
		System.out.println("Game thread is stopped by...."+ Thread.currentThread().getName()); 
		} 
	public void stop()
	{ 
		isStopped = true; 
		}

}
