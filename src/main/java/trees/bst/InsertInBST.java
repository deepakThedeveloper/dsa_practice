package trees.bst;

import lombok.val;
import trees.BalancedBinaryTree;
import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class InsertInBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        System.out.println("before deleting");
        BinaryTreePrinter.print(node);
//        insert(15, node);
        delete(8, node, node);
        BinaryTreePrinter.print(node);

    }

    private static void delete(int k, BinaryTreeNode node, BinaryTreeNode parent){
        if(k == node.getData()){
            if(node.getLeft() == null && node.getRight() == null){
                if(parent.getLeft() == node){
                    parent.left = null;
                }
                else{
                    parent.right = null;
                }
            }
            else {
                if(node.getRight()!=null){
                    BinaryTreeNode replaceNode = getRightLeftmostNode(node.getRight());
                    node.data = replaceNode.getData();
                }
            }
        }
        else if(k < node.getData()){
            delete(k, node.getLeft(), node);
        }
        else{
            delete(k, node.getRight(), node);
        }
    }


    private static void insert(BinaryTreeNode node){
        insert(15, node);
        BinaryTreePrinter.print(node);
    }

    private static BinaryTreeNode insert(int k, BinaryTreeNode node) {
        if(node == null) {
            return new BinaryTreeNode(k);
        }

        if(k < node.getData()){
            node.setLeft(insert(k, node.getLeft()));
        }
        else {
            node.setRight(insert(k, node.getRight()));
        }
        return node;
    }

    private static BinaryTreeNode getRightLeftmostNode(BinaryTreeNode node){
        BinaryTreeNode prev = node;
        while (node.getLeft()!=null){
            prev = node;
            node = node.getLeft();
        }
        if(node.getRight() == null){
            prev.setLeft(null);
            return node;
        }
        prev = node;
        node.data = node.getRight().getData();
        return prev;
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
