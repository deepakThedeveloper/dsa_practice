package trees;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        System.out.println("traversal before conversion");
        BinaryTreePrinter.print(node);
        convertBtToLL(node);

        System.out.println("traversal after conversion");
        while (prev!=null){
            System.out.print(prev.getData()+", ");
            prev = prev.getLeft();
        }
    }

    static BinaryTreeNode prev = null;
    private static void convertBtToLL(BinaryTreeNode node) {
        if(node == null) return;

        convertBtToLL(node.getRight());
        convertBtToLL(node.getLeft());
        node.setLeft(prev);
        prev = node;
        node.setRight(null);
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root7 = new BinaryTreeNode(7);
        BinaryTreeNode root8 = new BinaryTreeNode(8);
        BinaryTreeNode root9 = new BinaryTreeNode(9);
        BinaryTreeNode root10 = new BinaryTreeNode(10);
        BinaryTreeNode root11 = new BinaryTreeNode(11);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root4);
        root1.setRight(root5);
        root2.setLeft(root6);
        root2.setRight(root7);
        root4.setLeft(root8);
        root4.setRight(root9);
        root5.setLeft(root10);
        root5.setRight(root11);

        return root;
    }
}
