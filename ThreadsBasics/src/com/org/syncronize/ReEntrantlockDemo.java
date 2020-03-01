package com.org.syncronize;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
	
	String name;
	ReentrantLock lock = new ReentrantLock();
	boolean done = false;
	
	 Worker(String name, ReentrantLock lock){
		this.name = name;
		this.lock = lock;
	}
	@Override
	public void run() {
		
		while(!done){
			
			boolean isLockAvailable = lock.tryLock();
			if(isLockAvailable){
				try{
				Date d = new Date(); 
		          SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
				System.out.println("task name - "+ name 
	                     + " outer lock acquired at "
	                     + ft.format(d) 
	                     + " Doing outer work");
				Thread.sleep(1000);
					try{
						lock.lock();
						 d = new Date(); 
						System.out.println("task name - "+ name 
			                     + " inner lock acquired at "
			                     + ft.format(d) 
			                     + " Doing outer work");
						Thread.sleep(1000);
						System.out.println("Locks held by task name " + name+": "+lock.getHoldCount());
						done = true;
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					finally{
						System.out.println("task name - " + name + 
			                       " releasing inner lock"); 
						lock.unlock();
					}
				} catch(InterruptedException e){
					e.printStackTrace();
				} finally{
					System.out.println("Locks held by task name " + name+": "+lock.getHoldCount());

					System.out.println("task name - " + name + 
		                       " releasing outer lock"); 
					lock.unlock();
					System.out.println("Locks held by task name " + name+": "+lock.getHoldCount());
				}
				
			}else {
				System.out.println(name+" is waiting for lock");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
}

public class ReEntrantlockDemo {
	
	public static void main(String[] args){
		ReentrantLock lock = new ReentrantLock();
		ExecutorService executorService =  Executors.newFixedThreadPool(3);
		Worker thread1 = new Worker("Job1", lock);
		Worker thread2 = new Worker("Job2", lock);
		Worker thread3 = new Worker("Job3", lock);
		executorService.execute(thread1);
		executorService.execute(thread2);
		executorService.execute(thread3);
		executorService.shutdown();
		Thread t = Thread.currentThread();
		System.out.println("Main thread id: "+t.getId());
		
	}

}
