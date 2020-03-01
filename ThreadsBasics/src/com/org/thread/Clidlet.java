package com.org.thread;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

class Clidder  
{ static int i =0;

 Clidder(){
	i=9;
}	

    private final void flipper()  
    { 
        System.out.println("Clidder"); 
    } 
} 
  
public class Clidlet extends Clidder  
{ 
    public final void flipper()  
    { 
        System.out.println("Clidlet"); 
    } 
    public static void main(String[] args)  
    { 
    
    	int arr[] = new int[5];
    	arr[0]=
    	arr[0] =1;
    	arr[4]=2;
    	int arr2[];
    	int arr1[][] = new int[4][];
    	i=9;
    	i=arr.length ;
        new Clidlet().flipper(); 
        int x = 0;
        int y = 10;
//        int z = y/x;
        
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
        System.out.println(list.get(1));
        list.remove();
        System.out.println(list.toString());
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.put(1, 1));
        System.out.println(arr.length/2);
        
        String st = "1110";
        System.out.println(st.charAt(1)-'0');
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("1", 1);
    } 
} 
