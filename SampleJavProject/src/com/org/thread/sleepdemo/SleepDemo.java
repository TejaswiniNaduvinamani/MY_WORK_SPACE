package com.org.thread.sleepdemo;

import java.util.concurrent.TimeUnit;

public class SleepDemo {
	
	public static void main(String args[]) throws InterruptedException { 
		Game game = new Game(); 
		Thread t1 = new Thread(game, "T1"); 
		Thread t2 = new Thread(game, "T2");
		t1.start(); 
		t2.start();
		//Now, let's stop our Game thread 
		System.out.println(Thread.currentThread().getName() + " is stopping game thread"); 
		game.stop(); 
		//Let's wait to see game thread stopped 
		TimeUnit.MILLISECONDS.sleep(200); 
		System.out.println(Thread.currentThread().getName() + " is finished now"); 
	}
}
