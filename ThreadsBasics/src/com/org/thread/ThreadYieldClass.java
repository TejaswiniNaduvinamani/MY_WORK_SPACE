package com.org.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class MyThread extends Thread 
{ 
    public void run() 
    { 
        for (int i=0; i<10 ; i++) 
            System.out.println(Thread.currentThread().getName() 
                                + " in control"); 
        Thread.yield();
    } 
} 


  
public class ThreadYieldClass {
	public static void main(String[]args) 
    { 
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(1, "avc");
		map.put(2, "abc");
		map.put(5, "atc");
		map.put(4, "acc");
		map.put(6, "acc");
		map.put(3, "acc");
//		SortedMap<Integer, String> subMaps = map.subMap(1, 4);
		List<SortedMap<Integer, String>> subMaps= splitMap(map,5);
		System.out.println(subMaps);
		
		TreeMap<String, Integer> map1 = new TreeMap<>();
		map1.put("avc", 1);
		map1.put("abc", 2);
		map1.put("atc", 5);
		map1.put("acc" , 4);
		map1.put("akc", 6);
		map1.put("ajc", 8);
//		SortedMap<Integer, String> subMaps = map.subMap(1, 4);
		List<SortedMap<String, Integer>> subMaps1= splitMap(map1,2);
		System.out.println(subMaps1);
		
        MyThread t = new MyThread(); 
        t.start(); 
  
        for (int i=0; i<5; i++) 
        { 
            // Control passes to child thread 
            Thread.yield(); 
  
            // After execution of child Thread 
            // main thread takes over 
            System.out.println(Thread.currentThread().getName() 
                                + " in control"); 
        } 
    } 
	
	public static <K, V> List<SortedMap<K, V>> splitMap(final SortedMap<K, V> map, final int size) {
	    List<K> keys = new ArrayList<>(map.keySet());
	    List<SortedMap<K, V>> parts = new ArrayList<>();
	    final int listSize = map.size();
	    for (int i = 0; i < listSize; i += size) {
	        if (i + size < listSize) {
	            parts.add(map.subMap(keys.get(i), keys.get(i + size)));
	        } else {
	            parts.add(map.tailMap(keys.get(i)));
	        }
	    }
	    return parts;
	}
	

}
