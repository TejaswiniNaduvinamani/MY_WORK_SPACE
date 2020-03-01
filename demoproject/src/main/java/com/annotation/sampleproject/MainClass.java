package com.annotation.sampleproject;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class MainClass {
	
	@Autowired
	@Qualifier("first")
	private  MyComponent firstComponent;
	
	@Autowired
	@Qualifier("second")
	private  MyComponent secondComponent;
	
	@Autowired
	@Qualifier
	private  MyComponent thirdComponent;
	
	public static void main(String[] args){
				
		System.out.println("running main class");
		
		MainClass obj = new MainClass();
		obj.display();
		obj.listStremFeatures();
		
	}
	
	public void display(){
		System.out.println(1/0.0);
		/*System.out.println(firstComponent.getComponentName());
		System.out.println(secondComponent.getComponentName());
		System.out.println(thirdComponent.getComponentName());*/
	}
	
	public void listStremFeatures(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<100;i++){
			list.add(i);
		}
		list.removeIf(i->i==91);
		(list.stream().filter(i -> i>  90)).forEach(p -> System.out.println(p));
	}

}
