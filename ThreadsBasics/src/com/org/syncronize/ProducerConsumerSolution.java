package com.org.syncronize;

import java.util.ArrayList;
import java.util.List;

class ProducerConsumer{
	
	List<Integer> list = new ArrayList<>();
	int capacity = 1;
	int value = 0;
	
	public void produce() throws InterruptedException{
		while(true){
			synchronized (this) {
				if(list.size()==capacity){
					wait();
				}
				list.add(value);
				System.out.println("Produced a value : " + value);
				value++;
				notifyAll();
				Thread.sleep(1000); 
			}
		}
	}
	
	
	public void consume () throws InterruptedException{
		while(true){
			//wait(); --thows IllegalMonitorStateException as it is used outside synchronized block
			synchronized(this){
				// Replace with while loop no exception will come
				if(list.size()==0){
					wait();
				}
				System.out.println("Consumed the value : " + list.get(0));
				list.remove(0);
				notify();
				Thread.sleep(1000); 
			}
		}
	}
	
}


public class ProducerConsumerSolution {
	
	
	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();

		Thread t1 = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}

}
