package com.org.binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class FindInorderSucOfaNodeInTree {
	Node root;
	static Node next=null;
	static Node resNode;
	class Node {
		int key;
		Node left, right;
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
	
	public void searchForGivenNode(Node root, int key){
		if(root==null)
			return;
		else {
			next=root;
			searchForGivenNode(root.right, key);
			if(key==root.key){
				resNode=root;
			}
			searchForGivenNode(root.left, key);
		}
		
	}
	
	public static void main(String[] args){
		FindInorderSucOfaNodeInTree tree = new FindInorderSucOfaNodeInTree();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
	}
}
