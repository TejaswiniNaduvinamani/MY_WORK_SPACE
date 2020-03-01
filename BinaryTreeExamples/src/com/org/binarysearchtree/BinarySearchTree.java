package com.org.binarysearchtree;

class Node {
	int key;
	Node left;
	Node right;
	Node(int key) {
		this.key = key;
	}
}

public class BinarySearchTree {
	Node root;
	public Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else if (key < root.key) {
			root.left = insertRec(root.left, key);
		} else if (key > root.key) {
			root.right = insertRec(root.right, key);
		}
		return root;
	}

	public void insert(int key) {
		root = insertRec(root, key);

	}

	public void inorder(Node root) {
		if (root == null)
			return;
		else
			inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);

	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(4);
		tree.insert(50);
		tree.insert(3);
		tree.insert(5);
		tree.insert(65);
		tree.insert(30);
		tree.insert(40);
		tree.insert(20);
		tree.insert(70);
		tree.insert(60);
		tree.inorder(tree.root);
	}

}
