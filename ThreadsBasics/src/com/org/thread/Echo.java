package com.org.thread;

abstract class Vibrate  
{ 
    static String s = "-"; 
    Vibrate()  
    { 
        s += "v"; 
    } 
} 
   interface C  {
	 void test() throws NullPointerException ;
 }
   class D implements C {
		@Override
		public void test() {
			
		}
  }

public class Echo extends Vibrate
{ 
    Echo()   
    { 
        this(7); 
        s += "e"; 
    } 
    Echo(int x)  
    { 
        s += "e2"; 
    } 
    public static void main(String[] args)  
    { 
        System.out.print("made " + s + " "); 
        String s1="s";
        String s2 = "s";
        System.out.println(s1==s2);
        
        int i = 5, j=6;
        int a = i++ + j-- - ++i + j++;
        System.out.println(a);
    } 
    static 
    { 
        Echo e = new Echo(); 
        System.out.print("block " + s + " "); 
    } 
} 
