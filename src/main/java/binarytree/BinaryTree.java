package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root;

	public BinaryTree(Node root) {
		this.root = root;
	}

	public void addNode(int value) {
		Node newNode = new Node(value);

		if (root == null)
			root = newNode;
		else {
			Node currentNode = root;

			while (true) {
				if (currentNode.payload > newNode.payload) {
					if (currentNode.left == null) {
						currentNode.left = newNode;
						return;
					} else {
						currentNode = currentNode.left;
					}

				} else if (currentNode.payload < newNode.payload) {
					if (currentNode.right == null) {
						currentNode.right = newNode;
						return;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}

	}

	public Node findsNode(int value) {
		return findsNodeRecursive(root, value);
	}

	private Node findsNodeRecursive(Node currentNode, int value) {

		if (currentNode == null) return null;
		if (currentNode.payload == value) return currentNode;

		return currentNode.payload > value
			? findsNodeRecursive(currentNode.left, value)
			: findsNodeRecursive(currentNode.right, value);

	}

	public void deleteNode(int value) {
		root = deleteRecursive(root, value);
	}

	/* left sub-tree, root node, and right sub-tree. Return ordered list */
	public void traverseInOrder(Node currentNode) {
		if (currentNode != null) {
			traverseInOrder(currentNode.left);
			System.out.print(currentNode.payload + " ");
			traverseInOrder(currentNode.right);
		}
	}

	/* root node, left subtree, right subtree */
	public void traversePreOrder(Node currentNode) {
		if (currentNode != null) {
			System.out.print(currentNode.payload + " ");
			traversePreOrder(currentNode.left);
			traversePreOrder(currentNode.right);
		}
	}

	/* left subtree, right subtree, and root */
	public void traversePostOrder(Node currentNode) {
		if (currentNode != null) {
			traversePostOrder(currentNode.left);
			traversePostOrder(currentNode.right);
			System.out.print(currentNode.payload + " ");
		}
	}

	/*
	 * visits all the levels of the tree starting from the root, and from left to
	 * right.
	 */
	public void traverseLevelOrder(Node currentNode) {
		if (currentNode == null) return;
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(currentNode);
		
		while(!nodes.isEmpty()) {
			Node n = nodes.remove();
			
			System.out.print(n.payload + " ");
			if(n.left != null)
				nodes.add(n.left);
			
			if(n.right != null)
				nodes.add(n.right);
		}

	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}

		if (value == current.payload) {
			// Case 1: no children
			if (current.left == null && current.right == null) {
				return null;
			}

			// Case 2: only 1 child
			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}

			// Case 3: 2 children
			int smallestValue = findSmallestValue(current.right);
			current.payload = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (value < current.payload) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}

		current.right = deleteRecursive(current.right, value);
		return current;
	}

	private int findSmallestValue(Node root) {
		return root.left == null
			? root.payload
			: findSmallestValue(root.left);
	}

	public boolean isBinarySearchTree(Node rootNode) {		
		
		if(rootNode.left != null) {
			if(rootNode.payload > rootNode.left.payload)
				return isBinarySearchTree(rootNode.left);
			else
				return false;
		}	
			
		if(rootNode.right != null) {
			if(rootNode.payload < rootNode.right.payload)
				return isBinarySearchTree(rootNode.right);
			else
				return false;
		}		
			
		return true;
		
	}
}
