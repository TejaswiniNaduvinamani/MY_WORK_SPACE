package com.org.syncronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author tnaduvinamani
 *
 */
class CalculateSum{
	 
	 int sum =0;
	 
	 static int count =0;

	public int getSum() {
		return sum;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		CalculateSum.count = count;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	 
	public synchronized void synchronisedCalculate() {
	    setSum(getSum() + 1);
	}
	// sum will not be 1000 it will random value
//	public  void synchronisedCalculate() {
//	    setSum(getSum() + 1);
//	}
	
	public static synchronized void synchronisedStaticCalculate() {
	    setCount(getCount() + 1);
	}
	
//	public synchronized void synchronisesBlockCalcu
	
}

public class SynchronizedNonStaticAndStaticMethod {
	
	public static void main(String[] arg) throws InterruptedException{
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		CalculateSum sumObj = new CalculateSum();
		
		IntStream.range(0, 1000).forEach(s -> service.submit(sumObj::synchronisedCalculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		
		System.out.println("Non static sum : "+sumObj.getSum());
		
		IntStream.range(0, 1000).forEach(s -> service.submit(CalculateSum::synchronisedStaticCalculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		
		System.out.println("static sum : "+CalculateSum.getCount());
		
		IntStream.range(0, 1000).forEach(s -> service.submit(CalculateSum::synchronisedStaticCalculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		
		service.shutdown();
		System.out.println("static sum2 : "+CalculateSum.getCount());
		
		
	}

}
