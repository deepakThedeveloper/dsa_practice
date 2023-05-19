package trees.bst;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class InorderSuccessorInBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);
        //BinaryTreeNode successor = inorderSuccessor(node, node, 7);
        //System.out.println(successor);
        inorderSuccessorWithGlobalVariable(node, 5);
        System.out.println(successor);
    }

    private static BinaryTreeNode inorderSuccessorWithoutGlobalVariable(BinaryTreeNode node, BinaryTreeNode parent, int target){
        if(node == null) return null;

        if(node.data == target){
            if(node.getRight()!=null){
                return leftmostOfFirstRight(node.getRight());
            }
            else{
                if(parent.getLeft() == node){
                    return parent;
                }
                else {
                    return parent;
                }
            }
        }
        if(node.data>target){
            return inorderSuccessorWithoutGlobalVariable(node.getLeft(), node, target);
        }
        else{
            return inorderSuccessorWithoutGlobalVariable(node.getRight(), parent, target);
        }
    }

    static BinaryTreeNode successor = null;
    private static void inorderSuccessorWithGlobalVariable(BinaryTreeNode node, int target){
        if(node == null) return;

        if(node.data == target){
            if(node.getRight()!=null){
                successor =  leftmostOfFirstRight(node.getRight());
                return;
            }
        }
        if(node.data>target){
            successor = node;
            inorderSuccessorWithGlobalVariable(node.getLeft(), target);
        }
        else{
            inorderSuccessorWithGlobalVariable(node.getRight(), target);
        }
    }

    private static BinaryTreeNode leftmostOfFirstRight(BinaryTreeNode node){
        if(node == null) return null;
        while(node.getLeft()!=null){
            node = node.left;
        }
        return node;
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
