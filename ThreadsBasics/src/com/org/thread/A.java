package com.org.thread;

public class A extends B 
{ 
    public static String sing()  
    { 
        return "fa"; 
    } 
    public static void main(String[] args)  
    { 
        A a = new A(); 
        B b = new A(); 
    System.out.println(a.sing() + " " + b.sing()); 
    } 
} 
class B  
{ 
    public static String sing()  
    { 
        return "la"; 
    } 
} 