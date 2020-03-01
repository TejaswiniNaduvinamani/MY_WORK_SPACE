package com.org.thread;

 interface Test1 
{ 
    public int calculate(); 
     interface NestedInterface 
    { 
        public void nested(); 
    } 
} 

public class Test {
	 public static void main(String[] args) 
	    { 
	        String a = "GeeksforGeeks"; 
	        String b = new String(a); 
	        int value = 0; 
	        value = (a==b) ? 1:2; 
	        if(value == 1) 
	        { 
	            System.out.println("GeeksforGeeks"); 
	        } 
	        else if(value == 2) 
	        { 
	            System.out.println("Geeks for Geeks"); 
	        } 
	        else
	        { 
	            System.out.println("GFG"); 
	        } 
	        
	          
	    } 
}
