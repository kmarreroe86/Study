package datatreestructure;

import datatreestructure.TreeNode;
public class BinarySearchTree {

    private datatreestructure.TreeNode root;

    public BinarySearchTree(datatreestructure.TreeNode root) {
        this.root = root;
    }

    public void insert(int data) {

        TreeNode newNode = new datatreestructure.TreeNode(data);

        if (root == null) {
            root = newNode;
        } else {
            TreeNode currentNode = root;
            while (true) {
                if (currentNode.getData() >= newNode.getData()) {
                    if (currentNode.getLeftChild() == null){
                        currentNode.setLeftChild(newNode);
                        return;
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }
                } else {
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(newNode);
                        return;
                    } else {
                        currentNode = currentNode.getRightChild();
                    }
                }
            }
        }

    }

    public TreeNode find(int data) {
        return find(root, data);
    }

    private TreeNode find(TreeNode node, int value) {
        if (node == null) return null;
        if (node.getData() == value) return node;

        return node.getData() >= value ? find(node.getLeftChild(), value) : find(node.getRightChild(), value);
    }

    public void delete(int data) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = false;

        if (current == null) return;

        while (current != null && current.getData() != data){
            parent = current;

            if (data < current.getData()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }

        if (current == null) return;

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild)
                    parent.setLeftChild(null);
                else
                    parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        }
        // This is case 3 - Most complicated (node to be deleted has 2 children)
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }

    }

    public int smallest() {
        if (root == null) return Integer.MIN_VALUE;

        TreeNode currentNode = root;
        while (currentNode.getLeftChild() != null){
            currentNode = currentNode.getLeftChild();
        }

        return currentNode.getData();
    }

    public int largest() {
        if (root == null) return Integer.MIN_VALUE;

        TreeNode currentNode = root;
        while (currentNode.getRightChild() != null){
            currentNode = currentNode.getRightChild();
        }

        return currentNode.getData();
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode currentNode) {
        if (isLeaf(currentNode)) return 1;
        int left = 0;
        int right = 0;
        if (currentNode.getLeftChild() != null)
            left = height(currentNode.getLeftChild());
        if (currentNode.getRightChild() != null)
            right = height(currentNode.getRightChild());
        return (left > right) ? (left + 1) : (right + 1);
    }

    public boolean isLeaf(TreeNode currentNode) {
        return currentNode.getLeftChild() == null && currentNode.getRightChild() == null;
    }


    /* left subtree, root, right subtree*/
    private void inOrderTraversal(TreeNode currentNode) {
        if (currentNode != null) {
            inOrderTraversal(currentNode.getLeftChild());
            System.out.print(String.format("%d -> ", currentNode.getData()));
            inOrderTraversal(currentNode.getRightChild());
        }
    }

    /*root, left subtree, right subtree*/
    private void preOrderTraversal(TreeNode currentNode) {
        if (currentNode != null) {
            System.out.print(String.format("%d -> ", currentNode.getData()));
            preOrderTraversal(currentNode.getLeftChild());
            preOrderTraversal(currentNode.getRightChild());
        }
    }

    /*left subtree, right subtree, roo*/
    private void postOrderTraversal(TreeNode currentNode) {
        if (currentNode != null) {
            postOrderTraversal(currentNode.getLeftChild());
            postOrderTraversal(currentNode.getRightChild());
            System.out.print(String.format("%d -> ", currentNode.getData()));
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parentOfSuccessor = node;
        TreeNode successor = node;
        TreeNode current = node.getRightChild();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != node.getRightChild()) {
            parentOfSuccessor.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
        return successor;
    }
}
