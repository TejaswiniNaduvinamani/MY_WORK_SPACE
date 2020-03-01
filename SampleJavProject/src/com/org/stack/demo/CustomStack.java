package com.org.stack.demo;

import java.util.Stack;

public class CustomStack extends Stack {
	
	Stack st;
	
	CustomStack(Stack st){
		this.st = st;
	}
	
	@Override
	public Integer pop(){
		int temp = 0;
		Stack st1 = new Stack();
		st1= st;
		int size = st1.size();
		for(int i=0; i< size; i++){
			int j = (Integer)st1.pop();
			if( j>temp){
				temp = j;
			}
		}
		return temp;	
	}

}
