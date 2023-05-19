package trees.bst;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class LargestBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);

        NodeValue nodeValue = largestBST(node);
        System.out.println(nodeValue.size);
    }

    @AllArgsConstructor
    static class NodeValue{
        int size;
        int minValue;
        int maxValue;
    }

    private static NodeValue largestBST(BinaryTreeNode node) {
        if(node == null) {
            return new NodeValue(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeValue left = largestBST(node.getLeft());
        NodeValue right = largestBST(node.getRight());
        if(left.maxValue < node.data && node.data < right.minValue){
            return new NodeValue(left.size + right.size + 1, Math.min(node.data, left.minValue),
                    Math.max(node.data, right.maxValue));
        }
        return new NodeValue(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
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
