package com.org.exception;

import java.util.List;

class Demo {
	
	 public void method(List<String> demo){
	 try{
		 demo.get(0);
	 }catch(Exception e){
		 
	 }
	 }
}

public class DemoClass {

	public static void method(List<String> demo) {
//		try {
			int i = 1/0;
//		} catch (Exception e) {

//		}
	}

	public static void main(String[] args) {
//		DemoClass d = null;
//		d.method(null);
		try{
//		method(null);
			int i = 1/0;
		} catch(Exception e){
			e.getMessage();
		}
	}

}
