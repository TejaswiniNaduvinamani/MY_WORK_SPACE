package com.org.thread;
public class Outer  
{ 
    private static int data = 10; 
    private static int LocalClass() 
    { 
        class Inner 
        { 
            public int data = 20; 
            private int getData() 
            { 
                return data; 
            } 
        }; 
        Inner inner = new Inner(); 
        return inner.getData(); 
    } 
      
    public static void main(String[] args) 
    { 
    	int value = 3, sum = 6 + -- value; 
        
        int data = --value + ++value / sum++ * value++ + ++sum  % value--; 
        System.out.println(data); 
//        System.out.println(data * LocalClass()); 
    } 
} 
