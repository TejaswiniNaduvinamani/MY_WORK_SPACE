package com.org.threads.joindemo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

public class JoinDemoMain  {
	
	
	public static void main(String[] args){
		
		Thread t = Thread.currentThread();
		System.out.println(t);
		float f[] = new float[5];
		Object obj = f;
		System.out.println(f[0]);
		
	}

}
