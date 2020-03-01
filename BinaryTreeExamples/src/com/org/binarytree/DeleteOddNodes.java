package com.org.binarytree;


public class DeleteOddNodes {
	Node root;
	Node prev  ;
	static class Node {
		int data, horizontalDist;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
	
	public void inOrder(Node root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public void deleteOddeNode(Node root){
		
		if(root==null){
			return;
		}
		
		if(root.left != null && root.right != null){
			prev = root;
		}
		deleteOddeNode(root.left);
		if(root.left == null || root.right == null){
			if(prev.left==root)
				prev.left = root.left==null?root.right:root.left;
			if(prev.right==root)
				prev.right = root.left==null?root.right:root.left;
		}
		deleteOddeNode(root.right);
	}
	
	public static void main(String[] args) {
		DeleteOddNodes tree = new DeleteOddNodes();
		tree.root=new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.left = new Node(5);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(6);
		tree.root.right.right.right = new Node(7);
		tree.inOrder(tree.root);
		tree.deleteOddeNode(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
	}
}
