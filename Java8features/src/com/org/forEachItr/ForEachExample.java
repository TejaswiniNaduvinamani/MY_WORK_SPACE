package com.org.forEachItr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachExample {
	
	public static void main(String[] args){
		List<Integer> lt = new ArrayList<>();
		for(int i=0;i<5;i++)
			lt.add(i);
		
		// using lamda expression
		lt.forEach((i)-> System.out.println("printing list values: "+i));
		
		// by providing implementation to Consumer 
		System.out.println("----DISPLAY LIST WITH CUSTOM IMPLEMENTATION----");
		lt.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("printing list values by implementing consumer: "+ t);
			}
		});
		
		System.out.println("----DISPLAY LIST ELEMENTS WHICH ARE MULTIPLE OF 2----");
		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
	     
		Consumer<Integer> action = System.out::println;
		 
		numberList.stream().filter(n -> n%2  == 0).forEach( action );
		
		// For map
		HashMap<String, Integer> map = new HashMap<>();
	     
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		
		System.out.println("----DISPLAY MAP KEY VALUE PAIR WITH CUSTOM IMPLEMENTATION----");
		map.entrySet().forEach(entry ->{
			System.out.println("Key is " + entry.getKey());
			System.out.println("Value is " + entry.getValue());
		});
		// OR
		System.out.println("----DISPLAY MAP KEY VALUe PAIR----");
		Consumer<Map.Entry<String, Integer>> actionEntry = System.out::println;
		map.entrySet().forEach(actionEntry);
		
		// For displaying keys
		System.out.println("----DISPLAY MAP KEYS----");
		Consumer<String> actionKeys = System.out::println;
		map.keySet().forEach(actionKeys);
	}

}
