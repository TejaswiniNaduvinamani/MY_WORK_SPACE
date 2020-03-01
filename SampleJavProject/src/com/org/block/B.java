package com.org.block;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class B
{
    {
//        System.out.println(i); -- compilation error
    }
 
    int i = 10;
    
    static int methodOne(int i)
    {
        i = i++ + --i;
 
        return i;
    }
 
    static int methodTwo(int i)
    {
        i = i-- - ++i + methodOne(i);
 
        return i;
    }
    
    public static void main(String[] args){
    	int i=11;
//    	i= i++ - --i;
    	
    	System.out.println(methodTwo(i) + ++i - --i);
    	
    	Map<Integer, String> map = new HashMap<>();
    	map.put(1, "1");
    	map.put(2, "2");
    	map.put(3, "3");
    	Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
    	while(iterator.hasNext()){
    		if(iterator.next().getKey()==1){
    			iterator.remove();
    		}
    	}
    	map.put(1, "1");
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			if (entry.getKey() == 1) {
				map.remove(entry.getKey());
			}
		}
    }
}
