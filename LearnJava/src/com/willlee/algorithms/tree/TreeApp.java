package com.willlee.algorithms.tree;

class Node {
	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;

	public void displayNode() {
		System.out.print("{");
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
}

class Tree {
	// first node of tree
	private Node root;

	public Tree() {
		root = null;
	}

	public Node find(int key) {
		Node current = root;
		if (current == null) {
			return null;
		}
		while (current.iData != key) {
			if (key < current.iData) {
				current = current.leftChild;// go left
			} else {
				current = current.rightChild;// go right
			}
			if (current == null) {// if no child,didn't find it
				return null;
			}
		}
		return current;// found it!
	}

	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = dd;

		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent = null;
			while (true) {
				parent = current;
				if (id < current.iData) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.iData != key) {// search for node
			parent = current;
			if (key < current.iData) {// go left
				isLeftChild = true;
				current = current.leftChild;
			} else {// go right
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {// end of the line ,didn't find it
				return false;
			}
		}// end while

		// if no children, simple delete it
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (current.rightChild == null) {// if no right node,
			if (current == root) {// replace with left subtree
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if (current.leftChild == null) {// if no left node,
			if (current == root) {// replace with right subtree
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else {// two children,so replace with inorder successor
			return false;
		}
		return false;
	}

	private Node getSuccessor(Node delNode) {
		return null;
	}
}

public class TreeApp {
	public static void main(String[] args) {
	}
}
