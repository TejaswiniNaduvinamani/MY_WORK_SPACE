package com.org.binarytree;

public class HightOfBinaryTree {
	
	public static int hieght(Node root){
		if(root==null){
			return 0;
		}
		int left=hieght(root.left);
		int right=hieght(root.right);
		return Math.max(left, right)+1;
	}
	
	public static void deepestNode(Node root, int levels){
		if(root==null){
			return ;
		}
		else if(levels==1){
			System.out.println(root.key);
		}
		else if(levels>1){
			deepestNode(root.left, levels-1);
			deepestNode(root.right, levels-1);
		}
		
	}
	
	public static void main(String[] args) 
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.right = new Node(7);
		root.right.right.right = new Node(8);
		root.right.left.right.left = new Node(9);
		int hieght = hieght(root);
		System.out.println(hieght);
		deepestNode(root, hieght);
	}

}
