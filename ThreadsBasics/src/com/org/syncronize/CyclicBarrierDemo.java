package com.org.syncronize;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class TestBarrier extends Thread{
	@Override
	public void run(){
		System.out.println("Executing " + Thread.currentThread().getName());
		System.out.println("Waiting for other threads");
	
		try {
			CyclicBarrierDemo.barrier.await();
			System.out.println("All threads reached the barrier resuming back thread execution of " + Thread.currentThread().getName());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

public interface CyclicBarrierDemo {

	static CyclicBarrier barrier = new CyclicBarrier(3, () -> {
		System.out.println("Performing Action on reaching barrier");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	});
	
	public static void main(String[] args){
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for (int i=0; i<3; i++){
			service.submit(new TestBarrier());
		}
		System.out.println("--------");
		
		service.shutdown();
		System.out.println("Shutting down the thread pool");
	}

}
