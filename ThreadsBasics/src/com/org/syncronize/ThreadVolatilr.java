package com.org.syncronize;

class FieldVisibility{ 
	
	 int x =0;
	
	public void writterThread(){
		x=1;
	}
	
	public int readerThread(){
		 int r2  = x;
		return r2;
	}
	
}

public class ThreadVolatilr {
	
	
	public static void main(String args[]){
		FieldVisibility obj = new FieldVisibility();
		FieldVisibility obj1 = new FieldVisibility();
		Runnable r1 = () -> {obj.writterThread();};
		Runnable r2 = () -> { System.out.println(obj.readerThread());};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
	}
	


}
