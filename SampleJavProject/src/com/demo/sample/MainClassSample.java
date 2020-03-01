package com.demo.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;

public class MainClassSample {
	static{
		System.out.println("Main Static block");
	}
	
	// this will never be called as its constructor is not called 
	{
		System.out.println("Main Non-Static block");
	}
	
	public static void main(String[] args){

		System.out.println("Executing Main Method");
		StaticTestClass.setCount(5);
        
        //non-private static variables can be accessed with class name
		StaticTestClass.str = "abc";
		StaticTestClass se = new StaticTestClass();
        System.out.println(se.getCount());
        //class and instance static variables are same
        System.out.println(StaticTestClass.str +" is same as "+se.str);
        System.out.println(StaticTestClass.str == se.str);
        
        //static nested classes are like normal top-level classes
        StaticTestClass.MyStaticClass myStaticClass = new StaticTestClass.MyStaticClass();
        myStaticClass.count=10;
        
        StaticTestClass.MyStaticClass myStaticClass1 = new StaticTestClass.MyStaticClass();
        myStaticClass1.count=20;
        
        System.out.println(myStaticClass.count);
        System.out.println(myStaticClass1.count);
        
        Map<String, Integer> obj = new HashMap<>();
        
        obj.put("one", 1);
        obj.put("two", 2);
        
        Set<Entry<String, Integer>> keys = obj.entrySet();
        
        for (Entry<String, Integer> key :keys) {
        	System.out.println("Key"+ key.getKey());
        }
    }
		
	

}
