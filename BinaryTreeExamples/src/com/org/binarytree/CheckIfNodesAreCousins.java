package com.org.binarytree;


public class CheckIfNodesAreCousins {
	
	Node root;
	
	Node firstNodeParent;
	Node secondNodeParent;
	
	int firstNodeHeight;
	int secondNodeHeight;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}
	
	public void findLevelOfNode(Node root, int firstNode, int level){
		if(root==null)
			return;
		
		findLevelOfNode(root.left, firstNode, ++level);
		if(firstNode == root.data){
			firstNodeHeight = level;
		}
		findLevelOfNode(root.right, firstNode, level);
		
	}
	
	public void findParentNodeOfCousins(Node root, Node firstNode, int level){
		if(root==null)
			return;
		if(firstNode==root.left )
		findParentNodeOfCousins(root.left, firstNode, ++level);
		
		findParentNodeOfCousins(root.right, firstNode, level);
		
	}
	
	
	
	public int findHeightFromtheRoot(Node root, int node){
		if(root==null || root.data==node )
			return 0;
		int left=0;
		int right=0;
		if(root.data==node){
		 left = findHeightFromtheRoot(root.left, node);
		 right = findHeightFromtheRoot(root.right, node);
	}
		return Math.max(left, right) + 1;
	}
	
	public void checkIfNodesAreCousins(Node root, int firstNode, int secondNode){
		findLevelOfNode(root, firstNode, -1);
		System.out.println("level of first node : " + firstNodeHeight);
		findLevelOfNode(root, secondNode, -1);
		System.out.println("level of first node : " + firstNodeHeight);
//		firstNodeHeight = findHeightFromtheRoot(root, firstNode);
//		secondNodeHeight = findHeightFromtheRoot(root, secondNode);
//		System.out.println(firstNodeHeight);
//		System.out.println(secondNodeHeight);
//		if(firstNodeParent.data != secondNodeParent.data && firstNodeHeight== secondNodeHeight){
//			System.out.println("given nodes are cousins");
//		} else {
//			System.out.println("given nodes are not cousins");
//		}
	}
	
	public static void main(String[] args){
		CheckIfNodesAreCousins tree = new CheckIfNodesAreCousins();
		tree.root= new Node(6);
		tree.root.left= new Node(3);
		tree.root.right= new Node(5);
		tree.root.left.left= new Node(7);
		tree.root.left.right= new Node(8);
		tree.root.right.left= new Node(1);
		tree.root.right.right= new Node(9);
		tree.checkIfNodesAreCousins(tree.root, 5, 8);
	}
}
