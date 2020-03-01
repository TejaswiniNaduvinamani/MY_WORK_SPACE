package com.org.syncronize;

import java.util.stream.IntStream;

class Sender{
	
	public void send(String msg){
		System.out.println("Sending "+ msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n"+msg+" Sent");
	}
	
	public void test(){
		IntStream.range(0, 10).forEach(s -> System.out.println("Testing synchronization" + Thread.currentThread().getName() + s));
	}
}
class DummyClass{
	
}

class ThreadSend extends Thread{
	
	String msg;
	Sender sender;
//	 static DummyClass dummy = new DummyClass();
	DummyClass dummy;
	
	ThreadSend(String msg, Sender sender, DummyClass dummy){
		this.msg = msg;
		this.sender = sender;
		this.dummy =  dummy;
	}
	
	@Override
	public void run(){
		synchronized(dummy){
			
			sender.send(msg);
			
		}
		sender.test();
	}
}

public class SynchronizedDemo {
	
	public static void main(String[] args) throws InterruptedException{
		Sender sender = new Sender();
//		Sender sender2 = new Sender();
		 DummyClass dummy = new DummyClass();
		ThreadSend thread1= new ThreadSend("Hi", sender, dummy); 
		ThreadSend thread2= new ThreadSend("Bye", sender, dummy); 
		thread1.start();
		thread2.start();/*
		thread1.join();
		thread2.join();
		System.out.println("------------");*/

	}

}
