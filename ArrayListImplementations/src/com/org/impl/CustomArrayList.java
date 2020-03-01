package com.org.impl;

import java.util.Arrays;

public class CustomArrayList {
	
	private Integer[] element;
	
	private static final int DEFAULT_CAPACITY = 2;
	
	private int size;
	
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	public CustomArrayList(){
		element = new Integer[DEFAULT_CAPACITY];
	}
	
	public void add(int data){
		ensureCapacity(size+1);
		element[size] = data;
		size++;
	}
	
	public int get(int i){
		return element[i];
	}
	
	private void ensureCapacity(int minCapacity){
		if(minCapacity > element.length)
		grow(minCapacity);
	}
	
	private void grow(int minCapacity){
		int oldCapacity = element.length;
		int newCapacity = oldCapacity + oldCapacity >> 1;
		if(newCapacity-minCapacity < 0)
			newCapacity = minCapacity;
		if(newCapacity-MAX_ARRAY_SIZE >0)
		newCapacity = hugeCapacity(minCapacity);
		
		element = Arrays.copyOf(element, newCapacity);
	}
	
	
	private int hugeCapacity(int minCapacity) {
		if (minCapacity<0)
			throw new OutOfMemoryError();
		return minCapacity>MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
		
	}
	
	public int size(){
		return size;
	}
	
	@Override
	public String toString(){
		return element.toString();
	}
	
	public static void main(String[] args){
		CustomArrayList list = new CustomArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		for(int i=0;i<list.size;i++){
			System.out.println(list.get(i));
		}
		System.out.println(list.toString());
	}

}



