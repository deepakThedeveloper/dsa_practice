package trees.bst;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class ReplaceNodeValWithLargeValue {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);

        System.out.println();
        replaceWithLargeVal(node);
        System.out.println();
        BinaryTreePrinter.print(node);
    }

    static int sum = 0;
    private static void replaceWithLargeVal(BinaryTreeNode node){
        if(node == null) return;

        replaceWithLargeVal(node.right);
        int temp = node.data;
        node.data = sum + temp;
        sum += temp;

        replaceWithLargeVal(node.left);
    }

    // approach 1: pepcoding dsa playlist 1
    private static BinaryTreeNode removeByReplaceLeftMax(BinaryTreeNode node, int data){
        if(node == null) return null;

        if(data < node.data){
            node.left = removeByReplaceLeftMax(node.left, data);
        }
        else if(data > node.data){
            node.right = removeByReplaceLeftMax(node.right, data);
        }
        // else means data == node.val/ we found the node to be deleted,
        else{
            // intermittent node with 2 child. first find left max. then replace node val with left max val. then remove left max
            if(node.left !=null && node.right != null){
                int max = leftMax(node.left);
                node.data = max;
                node.left = removeByReplaceLeftMax(node.left, max);
                return node;
            }
            // deleting node with only left child. passing right child which will be replaced in place of node
            if(node.left != null){
                return node.left;
            }
            // deleting node with only right child. passing right child which will be replaced in place of node
            if(node.right != null){
                return node.right;
            }
            // deleting leaf node
            return null;
        }
        return node;
    }

    private static int leftMax(BinaryTreeNode node){

        while(node.right!=null){
            node = node.right;
        }
        return node.data;
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode node0= new BinaryTreeNode(50);
        BinaryTreeNode node1= new BinaryTreeNode(25);
        BinaryTreeNode node2= new BinaryTreeNode(70);
        BinaryTreeNode node3= new BinaryTreeNode(20);
        BinaryTreeNode node4= new BinaryTreeNode(30);
        BinaryTreeNode node5= new BinaryTreeNode(60);
        BinaryTreeNode node6= new BinaryTreeNode(80);
        BinaryTreeNode node7= new BinaryTreeNode(50);
        BinaryTreeNode node8= new BinaryTreeNode(65);

        node0.left=node1;
        node0.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node5.left=node7;
        node5.right=node8;

        return node0;
    }

}
