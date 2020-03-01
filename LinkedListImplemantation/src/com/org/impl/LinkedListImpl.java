package com.org.impl;

public  class LinkedListImpl {
	
	Node head;
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	public void push(int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;

	}
	
	public void pushAfterNode(int data, Node prevNode){
		
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		
	}
	
	public void pushEndNode(int data){
		
		Node newNode = new Node(data);
		
		if(head==null) {
			
			head = newNode;
		}
		else {
		Node last = head;
		while(last.next != null) {
			last = last.next;
			
		}
		
		last.next = newNode;		
		}
	}
	
	public void delete(int key){
		Node temp = head;
		Node prev=null;
		
		if(temp !=null && temp.data==key){
			head=temp.next;
			return;
		}
		
		while(temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp==null){
			return;
		}
	
		prev.next = temp.next;
		
	}
	
	void deleteNode(int position) 
    { 
        // If linked list is empty 
        if (head == null) 
            return; 
  
        // Store head node 
        Node temp = head; 
  
        // If head needs to be removed 
        if (position == 0) 
        { 
            head = temp.next;   // Change head 
            return; 
        } 
  
        // Find previous node of the node to be deleted 
        for (int i=0; temp!=null && i<position-1; i++) 
            temp = temp.next; 
  
        // If position is more than number of ndoes 
        if (temp == null || temp.next == null) 
            return; 
  
        // Node temp->next is the node to be deleted 
        // Store pointer to the next of node to be deleted 
        Node next = temp.next.next; 
  
        temp.next = next;  // Unlink the deleted node from list 
    } 
	
	
	void deleteList(){
		head = null ;
	}
	// Using iterative Solution
	int lenghtOfList(){
		int count = 0;
		Node temp = head;
		
		while(temp!= null){
			temp = temp.next;
			count ++;
		}
		
		return count;
	}
	
	// using Recursive solution
	
	int getCountRec(Node node){
		
		if(node == null){
			return 0;
		}
		 return 1+getCountRec(node.next);
	}
	
	int getCount(){
		return getCountRec(head);
	}
	
	
	// Using iterative solution 
	boolean search(int data){
		Node current = head;
		
		while(current != null){
			if(current.data == data){
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	
	int getNthNode(Node head, int x) {
		int count =1;
		if(x>lenghtOfList()-1){
			return 0;
		}
		if(count == x){
			return head.data;
		}
		else {
			return	getNthNode(head.next, x-1);
		}
	}
	
	int getNthNodeFromEnd(Node head, int x) {
		int count = lenghtOfList();
		if(x>lenghtOfList()-1){
			return 0;
		}
		if(count == x){
			return head.data;
		}
		else {
			return	getNthNode(head.next, x+1);
		}
	}
	
	public static void main(String[] args){
		LinkedListImpl list = new LinkedListImpl();
		
		
//		list.head = new Node(1);
//		Node nodeTwo = new Node(2);
//		Node nodeThree = new Node(3);
//		
//		list.head.next = nodeTwo;
//		nodeTwo.next = nodeThree;	
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		
//		list.pushEndNode(1);
//		list.pushEndNode(2);
//		list.pushEndNode(3);
		
		
		list.printList(list);
		
		//list.deleteNode(2);
		list.printList(list);
		System.out.println("Length: "+list.lenghtOfList());

		System.out.println("Length: "+list.getCount());
		System.out.println("Doeas exist: " + list.search(10));
		System.out.println("HashCode : "+ "abc".hashCode());
		
		System.out.println("find 3rd node: " + list.getNthNode(list.head,4));
		System.out.println("find 1st node from the end: " + list.getNthNodeFromEnd(list.head,0));
	}
	
	public void printList(LinkedListImpl list){
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
