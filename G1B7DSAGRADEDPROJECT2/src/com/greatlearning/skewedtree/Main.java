package com.greatlearning.skewedtree;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Main {
	Node node;

	public Main() {
		this.node = null;
	}

	public Node rightRotate(Node node) {
		Node temp = node.left;
		node.left = temp.right;
		temp.right = node;
		return temp;
	}

	public Node convertToRightSkewed(Node node) {
		if (node == null) {
			return null;
		}

		while (node.left != null) {
			node = rightRotate(node);
		}

		node.right = convertToRightSkewed(node.right);

		return node;
	}

	public void display(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");

		display(node.right);
	}

	public static void main(String[] args) {
		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		Node skewedTree = tree.convertToRightSkewed(tree.node);

		tree.display(skewedTree);
	}
}
