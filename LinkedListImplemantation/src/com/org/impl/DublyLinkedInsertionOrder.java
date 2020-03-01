package com.org.impl;

import com.org.impl.DoublyLinkedListImpl.Node;

public class DublyLinkedInsertionOrder {

	
	 Node head;

	class Node {

		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;

		}
	}
	
	public  void add(int data) {
		Node newNode = new Node(data);
		if(head != null){
			Node tem = head;
			while(tem.next != null){
				tem=tem.next;
			}
			
			newNode.prev=tem;
			tem.next=newNode;
		}
		else{
			head = newNode;
		}
	}
	
	public void printList(DublyLinkedInsertionOrder list){
		Node tnode = head; 
		while(tnode!=null){
			System.out.println(tnode.data);
//			if(list.head.data == 2){
//				list.pushAfterNode(4, list.head);
//			}
			tnode = tnode.next;				
		}
	}
	
	public static void main(String[] args){
		DublyLinkedInsertionOrder list = new DublyLinkedInsertionOrder();
		list.add(1);
		list.add(2);
		list.add(3);
		list.printList(list);
	}
}
