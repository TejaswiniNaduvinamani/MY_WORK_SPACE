package com.org.syncronize;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.stream.LongStream;

class SharedResource{
	synchronized void test1(SharedResource s1) throws InterruptedException{
		System.out.println("Test1 begins its execution");
		Thread.sleep(1000);
		s1.test2(this);
		
	}
	
	synchronized void test2(SharedResource s2) throws InterruptedException{
		System.out.println("Test1 begins its execution");
		Thread.sleep(1000);
		s2.test1(this);		
	}
}

class Thread1 extends Thread{
	
	SharedResource s1;
	SharedResource s2;
	
	Thread1(SharedResource s1, SharedResource s2){
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public void run(){
		try {
			s1.test1(s2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread2 extends Thread{
	
	SharedResource s1;
	SharedResource s2;
	
	Thread2(SharedResource s1, SharedResource s2){
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public void run(){
		try {
			s2.test1(s1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class DeadLockDemo {
	
	public static void main(String[] args) throws InterruptedException{
		SharedResource s1 = new SharedResource();
		SharedResource s2 = new SharedResource();
		
		Thread1 t1 = new Thread1(s1, s2);
		Thread2 t2 = new Thread2(s1, s2);
		t1.start();
		t2.start();
		Thread.sleep(5000);
		//To find deadlock threads
		ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
		long[] ids =  threadMxBean.findMonitorDeadlockedThreads();
		
		long[] deadLockIds =  threadMxBean.findDeadlockedThreads();
		System.out.println("Deadlock Threads Id : "+ ids + ", "+ deadLockIds);
		for(long id : ids){
			ThreadInfo info = threadMxBean.getThreadInfo(id);
			System.out.println("Resource for which the Thread is in blocked state: "+info.getLockName());
			System.out.println("the total number of times that the thread associated with this ThreadInfo blocked to enter or reenter a monitor: "+info.getBlockedCount());
			System.out.println("ID of the Thread which holds lock on shared object: "+info.getLockOwnerId());
			System.out.println("Name of the Thread which holds lock on shared object: "+info.getThreadName());
			System.out.println("Thread State: "+info.getThreadState());


		}
	}

}
