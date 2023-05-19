package trees.bst;

import trees.BinaryTreeNode;

public class CielInBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        ceilWithAllPartialVariable(9, node, Integer.MAX_VALUE);
        System.out.println(val);
    }

    static int diff = Integer.MAX_VALUE;
    static int val = -1;
    private static void ceilWithAllGlobalVariable(int k, BinaryTreeNode node) {
        if(node == null) return;

        if(k<=node.getData()){
            if(diff > node.getData() - k){
                diff = node.getData() - k;
                val = node.getData();
            }
            ceilWithAllGlobalVariable(k, node.getLeft());
        }
        else{
            ceilWithAllGlobalVariable(k, node.getRight());
        }
    }

    private static void ceilWithAllPartialVariable(int k, BinaryTreeNode node, int diff) {
        if(node == null) return;

        if(k> node.getData()){
            ceilWithAllPartialVariable(k, node.getRight(), diff);
        }
        else {
            if (diff > node.getData() - k) {
                diff = node.getData() - k;
                val = node.getData();
            }
            ceilWithAllPartialVariable(k, node.getLeft(), diff);
        }
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
