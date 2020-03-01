package com.org.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FailFastFailSafeDemo {
	
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			itr.next();
//			list.add(2);
		}
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(3);
		itr = list2.iterator();
		while(itr.hasNext()){
			itr.next();
//			list2.add(2);
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		Iterator itr1= map.entrySet().iterator();
		while(itr1.hasNext()){
			itr1.next();
			map.put(2, 2);
			System.out.println(map);
//			list2.add(2);
		}
		
		itr1 = map.keySet().iterator();
		while(itr1.hasNext()){
			itr1.next();
			map.put(3, 2);
			System.out.println(map);
//			list2.add(2);
		}
		
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		Iterator itr2 = set.iterator();
		while(itr2.hasNext()){
			itr2.next();
			set.add(2);
			System.out.println(set);
//			list2.add(2);
		}
		
		
		Map<String, String> cityCode = new HashMap<String, String>(); 
        cityCode.put("Delhi", "India"); 
        cityCode.put("Moscow", "Russia"); 
        cityCode.put("New York", "USA"); 
  
        Iterator iterator = cityCode.keySet().iterator(); 
  
        while (iterator.hasNext()) { 
            System.out.println(cityCode.get(iterator.next())); 
  
            // adding an element to Map 
            // exception will be thrown on next call 
            // of next() method. 
            cityCode.put("Istanbul", "Turkey"); 
        } 
	}

}
