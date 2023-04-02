package datatreestructure;

public class BinaryTreeDemo {

    public static void main (String[] args) {

        TreeNode node = new TreeNode(52);
        BinarySearchTree searchTree = new BinarySearchTree(node);
        searchTree.insert(33);
        searchTree.insert(25);
        searchTree.insert(39);
        searchTree.insert(12);
        searchTree.insert(27);
        searchTree.insert(48);
        searchTree.insert(34);
        searchTree.insert(65);
        searchTree.insert(60);
        searchTree.insert(78);
        searchTree.insert(72);
        searchTree.insert(70);
        searchTree.insert(90);

//        System.out.println(searchTree.find(63));
        System.out.println(String.format("Smallest: %d", searchTree.smallest()));
        System.out.println(String.format("Largest: %d", searchTree.largest()));
        System.out.println("Traversals");
        System.out.println("In order: ");
        searchTree.inOrderTraversal();
        System.out.println("\nPre Order:");
        searchTree.preOrderTraversal();
        System.out.println("\nPost Order:");
        searchTree.postOrderTraversal();
        System.out.print("\nHeight: ");
        System.out.println(searchTree.height());

    }
}
