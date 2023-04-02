package scalajavaexercises.javacode;

import java.util.Arrays;

/*
* Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s),
which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
* */
public class SerializeTree {

    static StringBuilder sb = new StringBuilder();
    static final String separator = "->";

    public static void main(String[] args) {

        Node root = new Node(5);

        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println("Print In order before processing: ");
        traverseInOrder(root);

        System.out.println("\nPrint serialization: ");
        System.out.println(serializeTree(root));

        Node r = deserialize(sb.toString());
        System.out.println("Print In order after deserialization: ");
        traverseInOrder(r);

    }

    public static String serializeTree(Node currentNode) {
        serialize(currentNode);

        return sb.delete(sb.length() - 2, sb.length()).toString();
    }

    public static Node deserialize(String strSerialized) {
        Integer[] treeVals = Arrays.stream(strSerialized.split(separator))
                .map(Integer::parseInt).toArray(Integer[]::new);
        Node root = new Node(treeVals[0]);
        for (int i = 1; i < treeVals.length; i++) {
            root.addNode(root, treeVals[i]);
        }

        return root;
    }

    /* Serialize pre-order: root node, left subtree, right subtree */
    private static void serialize(Node currentNode) {
        if (currentNode != null) {
            sb.append(currentNode.data + separator);
            serialize(currentNode.left);
            serialize(currentNode.right);
        }
    }

    public static void traverseInOrder(Node currentNode) {
        if (currentNode != null) {
            traverseInOrder(currentNode.left);
            System.out.print(currentNode.data + " ");
            traverseInOrder(currentNode.right);
        }
    }


}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public void addNode(Node root, int value) {
        Node newNode = new Node(value);

        if (root == null)
            root = newNode;
        else {
            Node currentNode = root;

            while (true) {
                if (currentNode.data > newNode.data) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    } else {
                        currentNode = currentNode.left;
                    }

                } else if (currentNode.data < newNode.data) {
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
}
