package com.org.syncronize;

import java.util.ArrayList;
import java.util.List;

class PC {
	List<Integer> list = new ArrayList<>();
	int capacity = 1;

	public void produce() throws InterruptedException {
		int value = 0;
		while(true){
		synchronized (this) {
			// if in place of while, "if" is used then there will be chances of consuming null if there are more than one
			//consumer thread 
			while(list.size()==capacity){
				wait();
			}
			System.out.println("Producer Produced : " + value);
			list.add(value++);
			notify();
			 Thread.sleep(1000); 
		}
		}
	}

	public void consume() throws InterruptedException {
		while(true){
		synchronized (this) {
			while(list.size()==0){
				wait();
			}
			int val = list.remove(0);
			System.out.println("Consumer Consumed value: " + val);
			notify();
			 Thread.sleep(1000); 
		}
		}

	}
}

public class ProducerConsumerDemo {
	
	public static void main(String[] args){
		final PC pc = new PC();
		Thread t1 =new Thread(()->{
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(()->{
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
	}

}
