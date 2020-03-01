package com.org.impl;

import java.util.Map;

public class CustomHashMap<K, V> {
	
	
	static class Node<K, V> implements Map.Entry<K, V>{
		
		final int hash;
		final K key;
		final V value;
		Node<K, V> next;
		
		Node(int hash, K key, V value, Node<K, V> next){
			this.key = key;
			this.value = value;
			this.next = next;
			this.hash = hash;
					
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			return null;
		}
		
		public final String toString(){
			return key + "=" + value;
		}
		
	}
	
	public CustomHashMap(){
	}
	
	static final int DEFAULT_CAPACITY=16;
	
	 transient Node<K,V>[] table;
	 
	 private int size ;
	 
	 
	

	public static void main(String[] args){
		
	}

}
