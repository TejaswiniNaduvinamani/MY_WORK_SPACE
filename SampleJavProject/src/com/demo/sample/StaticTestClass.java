package com.demo.sample;

public class StaticTestClass {
	//static block
    static{
        //can be used to initialize resources when class is loaded
        System.out.println("StaticExample static block");
        //can access only static variables and methods
        str="Test";
        setCount(2);
    }
    
    //multiple static blocks in same class
    static{
        System.out.println("StaticExample static block2");
    }
    
    {
    	System.out.println("StaticExample non static block");
    }
    
    StaticTestClass(){
    	System.out.println("creating Static class object");
    }
    
    
    //static variable example
    private static int count; //kept private to control its value through setter
    public static String str;
    
    public int getCount() {
        return count;
    }

    //static method example
    public static void setCount(int count) {
        if(count > 0)
        StaticTestClass.count = count;
        
        System.out.println("setting count");
    }
    
    //static util method
    public static int addInts(int i, int...js){
        int sum=i;
        for(int x : js) sum+=x;
        return sum;
    }

    //static class example - used for packaging convenience only
    public static class MyStaticClass{
        public int count;
        
    }

}


