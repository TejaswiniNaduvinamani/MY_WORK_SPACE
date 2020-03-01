package com.org.impl;

import com.org.impl.DublyLinkedInsertionOrder.Node;

public class SinglyLinkedListReverse {
	Node head;

	class Node {

		int data;
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
			tem.next=newNode;
		}
		else{
			head = newNode;
		}
	}
	public void printList(SinglyLinkedListReverse list){
		Node tnode = head; 
		while(tnode!=null){
			System.out.println(tnode.data);
//			if(list.head.data == 2){
//				list.pushAfterNode(4, list.head);
//			}
			tnode = tnode.next;				
		}
	}
	
	public void reverse(){
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current=next;
		}
		head=prev;
	}
	public void printMiddle(){
		int count = 0;
		Node mid = head;
		Node temp = head;
		 while (temp != null) 
		    { 
		        /* update mid, when 'count' is odd number */
		        if (count%2 != 0) 
		            mid = mid.next; 
		  
		        ++count; 
		        temp = temp.next; 
		    } 
		 if(mid !=null){
			 System.out.println("Middle element "+ mid.data);
		 }
	}
	public static void main(String[] args){
		SinglyLinkedListReverse list = new SinglyLinkedListReverse();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.printList(list);
		list.reverse();
		list.printList(list);
		list.printMiddle();
	}
	
}
