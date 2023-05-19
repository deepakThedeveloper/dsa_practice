package trees;

public class NodeCountInCompleteBT {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);
        int nodeCount = nodeCountInCBT(node);
        System.out.println(nodeCount);
    }

    private static int nodeCountInCBT(BinaryTreeNode node) {
        if(node == null) return 0;

        int lh = ht1(node.getLeft());
        int rh = ht2(node.getRight());

        if(lh == rh){
            return ((2<<(lh))-1);
        }
        else {
            return 1 + nodeCountInCBT(node.getLeft()) + nodeCountInCBT(node.getRight());
        }
    }

    private static int ht1(BinaryTreeNode node){
        int count = 0;
        while(node.getLeft()!=null){
            count++;
            node= node.getLeft();
        }
        return count;
    }

    private static int ht2(BinaryTreeNode node){
        int count = 0;
        while(node.getRight()!=null){
            count++;
            node= node.getRight();
        }
        return count;
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
