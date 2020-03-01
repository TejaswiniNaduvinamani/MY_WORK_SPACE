package com.demo.sample;

class Base { 
	public int val=10;
     public void show() { 
       System.out.println("Base::show() called"); 
    } 
     
     public void show3() { 
         System.out.println("Base::show3() called"); 
      } 
} 
   
class Derived extends Base { 

	public int val=1000;
    public void show() { 
       System.out.println("Derived::show() called"); 
    } 
    
    public void show2() { 
        System.out.println("Derived::show2() called"); 
     } 
} 

public class InheritanceQuestion {
	public static void main(String[] args) { 
        Base b = new Derived();
        Derived d = (Derived)b;
        b.show(); 
        d.show();
        d.show3();
        b.show3();
        Base b1 = new Derived();

        Derived d1 =(Derived) b1;
        b1.show();
        System.out.println(b1.val);
        System.out.println(b.val);
        System.out.println(d1.val);
        
        System.out.println(b instanceof Base);
//        b.show2();  -- compilation error
    } 
}
