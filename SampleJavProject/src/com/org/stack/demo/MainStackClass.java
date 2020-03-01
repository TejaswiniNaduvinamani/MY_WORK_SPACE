package com.org.stack.demo;

import java.util.Stack;

public class MainStackClass {
	
	public static void main(String[] args){
		
		Stack s = new Stack();
		s.push(1);
		s.push(10);
		s.push(2);
		s.push(4);
		s.push(0);
		s.push(-100);
		CustomStack st = new CustomStack(s);
		System.out.println(st.pop());
		System.out.println(st.pop());
		
	}

}
