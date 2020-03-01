package com.org.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ReplaceTreeWithInorderSucPrec {
	Node root;
	static int i =1;
	static int size = 0;
	
	class Node {
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
		}
	}
	
	public void insert(int key){
		Queue<Node> q = new LinkedList<>();
		if(root== null){
			root = new Node(key);
			size++;
			return;
		}else{
			q.add(root);
		}
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.left == null) {
				node.left = new Node(key);
				size++;
				break;
			} else {
				q.add(node.left);
			}
			if (node.right == null) {
				node.right = new Node(key);
				size++;
				break;
			} else {
				q.add(node.right);
			}

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
	
	public void inOrderArray(Node root, Integer[] arr){
		if(root==null)
			return;
		else {
			inOrderArray(root.left, arr);
			arr[i]=root.key;
			i++;
			inOrderArray(root.right, arr);
		}
	}
	
	public void replaceEachNodeWithSum(Node root, Integer[] arr){
		if(root==null)
			return;
		else{
			replaceEachNodeWithSum(root.left, arr);
			root.key = arr[i-1] + arr[i+1];
			i++;
			replaceEachNodeWithSum(root.right, arr);
			
		}
					
	}
	
	public static void main(String[] args){
		ReplaceTreeWithInorderSucPrec tree = new ReplaceTreeWithInorderSucPrec();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
//		tree.insert(10);
//		tree.insert(4);
//		tree.insert(50);
//		tree.insert(3);
//		tree.insert(5);
//		tree.insert(30);
//		tree.insert(65);
//		tree.insert(20);
//		tree.insert(40);
//		tree.insert(60);
//		tree.insert(70);
		tree.inorder(tree.root);
		System.out.println("size of the tree " + size);
		Integer arr[] = new Integer[size+2];
		arr[0]=0;
		tree.inOrderArray(tree.root, arr);
		arr[arr.length-1]=0;
		i=1;
		tree.replaceEachNodeWithSum(tree.root, arr);
		tree.inorder(tree.root);
	}

}
