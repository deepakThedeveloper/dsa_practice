package trees.bst;

import lombok.AllArgsConstructor;
import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class IsBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);
        boolean isBst = isBst(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(isBst);
    }

    private static boolean isBst(BinaryTreeNode node, int min, int max){
        if(node == null){
            return true;
        }

        boolean left = isBst(node.getLeft(), min, node.data);
        boolean right = isBst(node.getRight(), node.data, max);
        return left && right && min < node.data && node.data < max;
    }

    @AllArgsConstructor
    static class Data{
        boolean isBst;
        int leftBiggest;
        int rightSmallest;
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode node0= new BinaryTreeNode(8);
        BinaryTreeNode node1= new BinaryTreeNode(5);
        BinaryTreeNode node2= new BinaryTreeNode(12);
        BinaryTreeNode node3= new BinaryTreeNode(4);
        BinaryTreeNode node4= new BinaryTreeNode(7);
        BinaryTreeNode node5= new BinaryTreeNode(9);
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
