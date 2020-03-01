package com.org.thread;

class MultithreadingDemo implements Runnable, Cloneable 
{ 
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                                Thread.currentThread().getId() + 
                                " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    }
    
    public Object myClone(){
		return new MultithreadingDemo();
    	
    }
} 

public class MainThreadClass {
	public static void main(String[] args) throws CloneNotSupportedException 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            Thread object = new Thread(new MultithreadingDemo()); 
            object.start(); 
            System.out.println(object.getContextClassLoader());
            System.out.println("thread group : "+object.getThreadGroup());
            object.interrupt();
            
           System.out.println("is interrupted"+object.isInterrupted());
//            MainThreadClass obj = (MainThreadClass) (new MainThreadClass()).clone();
//            MultithreadingDemo o = (new MultithreadingDemo()) ;
//            object.clone();
        } 
    } 

}
