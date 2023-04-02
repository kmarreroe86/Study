package binarytree;

public class Main {

	public static void main(String[] args) {
		Node root = new Node(6);
		BinaryTree tree = new BinaryTree(root);
		tree.addNode(4);
		tree.addNode(3);
		tree.addNode(8);
		tree.addNode(5);
		tree.addNode(9);
		tree.addNode(7);
		
		Node n = tree.findsNode(6);
		System.out.println((n != null ? n.payload : "null"));
		
		tree.deleteNode(6);		
		Node n2 = tree.findsNode(6);
		System.out.println((n2 != null ? n2.payload : "null"));
		
		System.out.println("Traverse InOrder:");
		tree.traverseInOrder(tree.root);
		
		System.out.println("\nTraverse PreOrder:");
		tree.traversePreOrder(tree.root);

		System.out.println("\nTraverse PostOrder:");
		tree.traversePostOrder(tree.root);

		System.out.println("\nTraverse LevelOrder:");
		tree.traverseLevelOrder(tree.root);
		
		System.out.println("\nChecking is BT is BST");
		Node testRoot = new Node(6);
		BinaryTree testTree = new BinaryTree(testRoot);
		testTree.addNode(4);
		testTree.addNode(3);
		testTree.addNode(7);
		testTree.addNode(8);
		testTree.addNode(5);
		testTree.addNode(9);
		
		System.out.println(testTree.isBinarySearchTree(testTree.root));		

	}

}
