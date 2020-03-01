package com.org.binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class InorderPredecessorOfTree {
	Node root;
	static Node prev=null;
	class Node {
		int key;
		Node left, right, prev;
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
			findInorderSuccessor(root.left);
			root.prev = prev;
			prev=root;
			findInorderSuccessor(root.right);		
		}
	}
	
	public void inorder(Node root){
		if(root==null)
			return;
		else {
			inorder(root.left);
			System.out.println(root.key + " Predecessor is " + (root.prev!= null?root.prev.key : "No Inorder predecessor as it is a left most node"));
			inorder(root.right);
		}
	}
	
	public static void main(String[] args){
		InorderPredecessorOfTree tree = new InorderPredecessorOfTree();
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
