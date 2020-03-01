package com.org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InorderSuccessorOfTree {
	Node root;
	static Node next=null;
	class Node {
		int key;
		Node left, right, next;
		Node(int key){
			this.key = key;
		}
	}
	
	public void insert(int key){
		Queue<Node> q = new LinkedList<>();
		if(root== null){
			root = new Node(key);
			return;
		}else{
			q.add(root);
		}
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.left == null) {
				node.left = new Node(key);
				break;
			} else {
				q.add(node.left);
			}
			if (node.right == null) {
				node.right = new Node(key);
				break;
			} else {
				q.add(node.right);
			}

		}
	}
	
	public void findInorderSuccessor(Node root){
		if(root==null)
			return;
		else {
			findInorderSuccessor(root.right);
			root.next = next;
			next=root;
			findInorderSuccessor(root.left);		
		}
	}
	
	public void inorder(Node root){
		if(root==null)
			return;
		else {
			inorder(root.left);
			System.out.println(root.key + " successor is " + (root.next!= null?root.next.key : "No Inorder Successor as its a right most node"));
			inorder(root.right);
		}
	}
	
	public static void main(String[] args){
		InorderSuccessorOfTree tree = new InorderSuccessorOfTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.findInorderSuccessor(tree.root);
		tree.inorder(tree.root);
	}

}
