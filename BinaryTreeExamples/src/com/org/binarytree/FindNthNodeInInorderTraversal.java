package com.org.binarytree;


public class FindNthNodeInInorderTraversal {

	Node root;
	static int count=0;
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
	
	public void findNthNode(Node root, int n){
		if(root==null)
		return;
		findNthNode(root.left, n);
		count++;
		if(count==n){
			System.out.println(n+ "th node is : " + root.data);
		}
		findNthNode(root.right, n);
	}
	
	public static void main(String[] args) {
		FindNthNodeInInorderTraversal tree = new FindNthNodeInInorderTraversal();
		tree.root = new Node(7);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(5);
		tree.findNthNode(tree.root, 1);
		
	}
}
