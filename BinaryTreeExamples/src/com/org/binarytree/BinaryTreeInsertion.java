package com.org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int key;
	Node left, right;

	Node(int key) {
		this.key = key;
		left = right = null;
	}
}

public class BinaryTreeInsertion {

	Node root;

	void inOrder(Node temp) {
		if (temp == null)
			return;
		inOrder(temp.left);
		System.out.print(temp.key + " ");
		inOrder(temp.right);
	}

	void preOrder(Node temp) {
		if (temp == null)
			return;
		System.out.print(temp.key + " ");
		preOrder(temp.left);
		preOrder(temp.right);
	}

	void postOrder(Node temp) {
		if (temp == null)
			return;
		postOrder(temp.left);
		postOrder(temp.right);
		System.out.print(temp.key + " ");
	}

	void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.key + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	void insertIntoTree(int key) {
		Queue<Node> queue = new LinkedList<>();
		Node temp = root;
		queue.add(temp);
		if (root == null) {
			root = new Node(key);
			return;
		}
		while (!queue.isEmpty()) {
			temp = queue.peek();
			queue.poll();
			if (temp.left == null) {
				Node newNode = new Node(key);
				temp.left = newNode;
				break;
			} else
				queue.add(temp.left);
			if (temp.right == null) {
				Node newNode = new Node(key);
				temp.right = newNode;
				break;
			} else
				queue.add(temp.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeInsertion tree = new BinaryTreeInsertion();
		tree.insertIntoTree(10);
		tree.insertIntoTree(11);
		tree.insertIntoTree(7);
		tree.insertIntoTree(9);
		tree.insertIntoTree(15);
		tree.insertIntoTree(8);
		tree.insertIntoTree(12);
		tree.insertIntoTree(1);
		tree.insertIntoTree(2);
		tree.insertIntoTree(5);
		tree.insertIntoTree(6);
		System.out.println("In order traversal");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("Pre order traversal");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("Post order traversal");
		tree.postOrder(tree.root);
		System.out.println();
		System.out.println("Level order traversal");
		tree.levelOrder(tree.root);
	}
}
