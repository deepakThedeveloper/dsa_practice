package trees.bst;

import trees.BinaryTreeNode;

public class SearchInBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreeNode found = search(12, node);
        System.out.println(found);
    }

    public static BinaryTreeNode search(int k, BinaryTreeNode node) {
        if(node == null) return null;

        if(k==node.getData()) return node;
        return k<node.getData() ? search(k, node.left) : search(k, node.getRight());
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode node0= new BinaryTreeNode(8);
        BinaryTreeNode node1= new BinaryTreeNode(5);
        BinaryTreeNode node2= new BinaryTreeNode(12);
        BinaryTreeNode node3= new BinaryTreeNode(4);
        BinaryTreeNode node4= new BinaryTreeNode(7);
        BinaryTreeNode node5= new BinaryTreeNode(10);
        BinaryTreeNode node6= new BinaryTreeNode(14);
        BinaryTreeNode node7= new BinaryTreeNode(6);
        BinaryTreeNode node8= new BinaryTreeNode(13);

        node0.left=node1;
        node0.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node6.left=node8;
        node4.left=node7;

        return node0;
    }
}
