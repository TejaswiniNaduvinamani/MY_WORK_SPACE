package com.org.syncronize;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

class CallableTask implements Callable<Integer>{
	Semaphore semp;
	
	CallableTask(Semaphore semp){
		this.semp = semp;
	}

	@Override
	public Integer call() throws Exception {
		semp.acquire();
		System.out.println("Executing the task : " + Thread.currentThread().getName());
		Thread.sleep(1000);
		semp.release();
		return Integer.parseInt(Long.valueOf(Thread.currentThread().getId()).toString());
	}
	
}

public class CallableExecutorDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		List<Future<Integer>> future = new ArrayList<>();
		Semaphore semp = new Semaphore(3);
		ExecutorService service = Executors.newFixedThreadPool(5);
		IntStream.range(0, 5).forEach(s -> {
			future.add(service.submit(new CallableTask(semp)));
			});
//		for (int i =0; i<50 ; i++){
//			System.out.println("Didnt get future value yet : " + i+ "st try");
//		}
		Thread.sleep(1000);
		System.out.println("Didnt get future value yet : " );
		for(Future<Integer> ftr : future){
			// Anything before this get() is called on future object will be executed asynchronously
			System.out.println("future value : " + ftr.get());
		}
		service.shutdown();
		System.out.println("All the threads are completed and returned a value");
		
	}

}
