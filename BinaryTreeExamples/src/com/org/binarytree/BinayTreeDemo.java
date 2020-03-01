package com.org.binarytree;

//class Node{
//	
//	int key;
//	Node left, right;
//	
//	Node(int key){
//		this.key = key;
//		left=right =null;
//	}
//}

public class BinayTreeDemo {
	
	Node root;
	
	BinayTreeDemo(){
		root = null;
	}
	
	BinayTreeDemo(int key){
		root = new Node(key);
	}
	
	public static void main(String[] args) {
		
		BinayTreeDemo tree = new BinayTreeDemo();
		tree.root = new Node(1);
		
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		tree.root.left.left = new Node(4);
		
	}

}
