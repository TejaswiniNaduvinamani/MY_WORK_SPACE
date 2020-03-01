package com.org.stackemo;

import java.util.Stack;

public class NextGreaterElement {
	
	public static void main(String[] args){
		int arr[] = {5,4,3,2,1};
		
		Stack<Integer> st = new Stack();
		for(int i=0;i<arr.length; i++){
			
			if (st.isEmpty()) {
				st.push(arr[i]);
			}
			else if (st.peek() < arr[i]) {
				while(!st.isEmpty()){
				System.out.println(st.pop() + "----" + arr[i]);
				}
				st.push(arr[i]);
			} else {
				st.push(arr[i]);
			}
				
			
		}
		while(!st.isEmpty()){
			System.out.println(st.pop() + "---- " + -1);
	
		}
		
	}

}
