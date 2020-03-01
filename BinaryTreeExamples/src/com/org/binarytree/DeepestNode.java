package com.org.binarytree;

public class DeepestNode {
	static int maxLevel = 0;
	static int res = -1;

	public static void find(Node root, int level) {
		if (root == null)
			return;
		find(root.left, ++level);
		if (level > maxLevel) {
			res = root.key;
			maxLevel = level;
		}
		find(root.right, level);
	}

	public static int deepestNode(Node root) {
		find(root, 0);
		return res;
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.right = new Node(7);
		root.right.right.right = new Node(8);
		root.right.left.right.left = new Node(9);
		root.right.left.right.right = new Node(10);
		System.out.println(deepestNode(root));
		System.out.println(maxLevel);
	}

}
