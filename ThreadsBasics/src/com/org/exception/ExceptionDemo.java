package com.org.exception;

import java.io.IOException;

import com.org.syncronize.ThreadVolatilr;

class SuperClass{
	
	public void method() throws IOException{
	}
	
	public static void method1() throws OutOfMemoryError{
		 throw new OutOfMemoryError();
	}
}

public class ExceptionDemo extends SuperClass{
	public void method() throws NullPointerException {
		 
	}
	
	public static void main(String[] args) throws ClassNotFoundException
    {
        System.out.println(methodReturningValue());
       // Class.forName("ThreadVolatilr");
        ThreadVolatilr obj = new ThreadVolatilr();
        try{
        	throw new OutOfMemoryError();
        } catch(OutOfMemoryError e){
        	System.out.println("Exception handled");
        }
    }
 
    static int methodReturningValue()
    {
        int i = 0;
 
        try
        {
            i = 1;
            return i;
        }
        catch (Exception e)
        {
            return i = 2;
        }
        finally
        {
             i = 3;
        }
//        i=5;
//        return i;
    }
}
