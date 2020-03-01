package com.org.binarytree;

public class LeftViewOfBinaryTree {
	
	static int maxlevel=-1;
	
	public static void findLeftView(Node root, int level){
		if(root==null){
			return ;
		}
		if(level>maxlevel){
			System.out.println(root.key);
			maxlevel=level;
		}
		findLeftView(root.left, ++level);
		findLeftView(root.right, level);
	}
	
	public static void findRightView(Node root, int level){
		if(root==null){
			return ;
		}
		if(level>maxlevel){
			System.out.println(root.key);
			maxlevel=level;
		}
		findRightView(root.right, ++level);
		findRightView(root.left, level);
	}
	
	 static void inOrder(Node temp){
			if(temp==null)
				return;
			
			inOrder(temp.left);
			System.out.print(temp.key+" ");
			inOrder(temp.right);
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
		System.out.println("left view of tree");
		findLeftView(root,0);
		System.out.println("right view of tree");
		maxlevel=-1;
		findRightView(root, 0);
		inOrder(root);
	}
}
