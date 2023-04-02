package datatreestructure;

public class TreeNode {

    private int data;

    private TreeNode leftChild;

    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node data: " + this.data;
    }
}
