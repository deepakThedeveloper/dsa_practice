package trees.view;

import trees.BinaryTreeNode;
import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalView {
    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = getTree();
        BinaryTreePrinter.print(binaryTreeNode);

        // expected op: 1,3,7,2,5,6,4,8,9,10
        diagonalView(binaryTreeNode);
    }
    private static void diagonalView(BinaryTreeNode node){
        Queue<BinaryTreeNode> rQueue = new LinkedList<>();
        Queue<BinaryTreeNode> lQueue = new LinkedList<>();

        rQueue.add(node);
        while (!rQueue.isEmpty() || !lQueue.isEmpty()){
            while (!rQueue.isEmpty()){
                BinaryTreeNode node1 = rQueue.poll();
                System.out.print(node1.data+", ");
                if(node1.right!=null){
                    rQueue.add(node1.right);
                }
                if(node1.left!=null){
                    lQueue.add(node1.left);
                }
            }
            if(!lQueue.isEmpty()){
                rQueue.add(lQueue.poll());
            }
        }
    }
    private static BinaryTreeNode getTree(){
        BinaryTreeNode leaf9 = new BinaryTreeNode(9);
        BinaryTreeNode leaf8 = new BinaryTreeNode(10);
        BinaryTreeNode mid3 = new BinaryTreeNode(4);
        BinaryTreeNode mid4 = new BinaryTreeNode(5);
        BinaryTreeNode mid1 = new BinaryTreeNode(2);
        mid1.setLeft(mid3);
        mid1.setRight(mid4);

        BinaryTreeNode mid5 = new BinaryTreeNode(6);
        BinaryTreeNode mid6 = new BinaryTreeNode(7);
        BinaryTreeNode mid2 = new BinaryTreeNode(3);
        BinaryTreeNode mid7 = new BinaryTreeNode(8);
        BinaryTreeNode root = new BinaryTreeNode(1);

        root.setLeft(mid1);
        root.setRight(mid2);
        mid2.setLeft(mid5);
        mid2.setRight(mid6);
        mid4.left = mid7;
        mid5.left = leaf9;
        leaf9.left = leaf8;

        return root;
    }
}
