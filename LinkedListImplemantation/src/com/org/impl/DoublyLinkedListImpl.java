package com.org.impl;

import com.org.impl.LinkedListImpl.Node;

public class DoublyLinkedListImpl {

	Node head;

	class Node {

		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;

		}
	}
	
	public void add(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
		 if(head != null ){
			 head.prev = newNode;
		 }
		head= newNode;
		
	}
	
	public void addAfterNode(int pos, int data){
		
		if(head == null){
			return ;
		}
		Node newNode = new Node(data);
		int count=0;
		Node temp = head ;
		while(temp.next != null) {
			count ++;
			if(count == pos){
				newNode.prev = temp;
				newNode.next = temp.next;
				temp.next = newNode;
				return;
			}
			temp = temp.next;
		}
		
		
	}
	
	public static void main(String[] args){
		DoublyLinkedListImpl doublyLinkedList = new DoublyLinkedListImpl();
		doublyLinkedList.add(1);
		doublyLinkedList.add(2);
		doublyLinkedList.add(3);
		doublyLinkedList.addAfterNode(3, 4);
		doublyLinkedList.printList(doublyLinkedList);
		
		
	}
	
	public void printList(DoublyLinkedListImpl list){
		Node tnode = head; 
		while(tnode!=null){
			System.out.println(tnode.data);
//			if(list.head.data == 2){
//				list.pushAfterNode(4, list.head);
//			}
			tnode = tnode.next;				
		}
	}

}
