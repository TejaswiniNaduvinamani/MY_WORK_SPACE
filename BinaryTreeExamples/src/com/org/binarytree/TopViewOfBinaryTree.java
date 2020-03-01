package com.org.binarytree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
	
	Node root;

	static class Node {
		int data, horizontalDist;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
	
	public static void topViewOfTree(Node root){
		Queue<Node> q = new LinkedList<Node>();
		if(root==null){
			return;
		}
		root.horizontalDist=0;
		q.add(root);
		Map<Integer, Node> map = new TreeMap<>();
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(!map.containsKey(temp.horizontalDist)){
				map.put(temp.horizontalDist, temp);
			}
			if(temp.left!=null){
				temp.left.horizontalDist = temp.horizontalDist-1;
				q.add(temp.left);
			}
			if(temp.right!=null){
				temp.right.horizontalDist = temp.horizontalDist+1;
				q.add(temp.right);
			}
			
		}
		for(Node node : map.values()){
			System.out.print(node.data + " ");
		}
		
	}

	public static void main(String[] args) {
		
		Node root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14);
        System.out.println("Following are nodes in top view of Binary Tree");
        topViewOfTree(root);
        
        root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.right = new Node(4); 
        root.left.right.right = new Node(5); 
        root.left.right.right.right = new Node(6); 
        System.out.println();
        System.out.println("Following are nodes in top view of Binary Tree");  
        topViewOfTree(root); 
	}
}
