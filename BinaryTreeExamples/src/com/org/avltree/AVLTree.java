package com.org.avltree;

public class AVLTree {
	
	Node root;

	class Node {
		int key, height;
		Node left, right;
		
		Node(int key){
			this.key = key;
		}
	} 
	
	public int height(Node node){
		if(node==null)
			return -1;
		else
			return node.height;		
	}
	
	public Node rotateRight(Node node){
		Node newRoot = node.left;
		Node temp = newRoot.right;
		
		newRoot.right =node;
		node.left=temp;
		node.height = Math.max(height(node.left), height(node.right))+1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;
		return newRoot;
	}
	
	public Node rotateLeft(Node node){
		Node newRoot = node.right;
		Node temp = newRoot.left;
		newRoot.left = node;
		node.right=temp;
		node.height = Math.max(height(node.left), height(node.right))+1;
		newRoot.height = Math.max(height(newRoot.left), height(newRoot.right))+1;
		return newRoot;
	}
	
	public int getBalance(Node node) {
		if (node==null)
			return 0;
		else 
			return height(node.left)-height(node.right);
	}
	
	public Node insert(Node root, int key){
		if(root == null){
		 root = new Node (key);
		 return root;
		}
		else if(key < root.key){
			 root.left = insert(root.left, key);
		 }
		else if (key>root.key){
			root.right=insert(root.right, key);
		} else 
			return root;
		root.height = Math.max(height(root.left), height(root.right))+1;
		int balance = getBalance(root);
		if(balance > 1 && key < root.key){
			return rotateRight(root);
		}
		if(balance > 1 && key> root.key){
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		if(balance < -1 && key > root.key)	
			return rotateLeft(root);
		if(balance < -1 && key < root.key){
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		return root;		
	}
	
	public void preorder(Node root){
		if(root==null)
			return;
		else {
			System.out.print(root.key + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	public void inorder(Node root){
		if(root==null)
			return;
		else {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
	
	public static void main (String[] args) {
		AVLTree tree = new AVLTree();
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 3);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 60);
		tree.root = tree.insert(tree.root, 70);
		tree.root = tree.insert(tree.root, 65);
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
	}
}
