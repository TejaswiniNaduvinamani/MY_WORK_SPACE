package com.org.syncronize;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

class TestPhaser extends Thread{
	Phaser phaser;
	
	TestPhaser(Phaser phaser){
		this.phaser = phaser;
	}
	
	@Override
	public void run(){
		System.out.println("Executing " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		phaser.arrive();
	}
	
}

public class PhaserDemo {
	
	public static void main(String[] args) throws InterruptedException{
		Phaser phaser = new Phaser(6);
		
		TestPhaser t1 = new TestPhaser(phaser);
		TestPhaser t2 = new TestPhaser(phaser);
		TestPhaser t3 = new TestPhaser(phaser);
		TestPhaser t4 = new TestPhaser(phaser);
		TestPhaser t5 = new TestPhaser(phaser);
		TestPhaser t6 = new TestPhaser(phaser);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		System.out.println("Waiting for other threads to complete their execution");
		phaser.awaitAdvance(0);
		System.out.println("Executing main thread after all 3 threads completion");
		BigDecimal num = new BigDecimal("0");
		System.out.println(num.setScale(2, RoundingMode.HALF_UP).compareTo(BigDecimal.ZERO));
	}

}
