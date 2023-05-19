package trees.bst;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class KthSmallest {
    public static void main(String[] args) {
        BinaryTreeNode node1 = getTree();
        BinaryTreePrinter.print(node1);
        BinaryTreeNode node = ksmallest(node1, 6);
        System.out.println(node);
    }

    static Integer count = 0;
    private static BinaryTreeNode ksmallest(BinaryTreeNode node, int k) {
        if (node == null)
            return null;

        BinaryTreeNode left = ksmallest(node.left, k);
        if (left != null)
            return left;
        // incrementing counter only when traversing to right, because big values than current will be only at right
        count++;
        if (count == k)
            return node;
        return ksmallest(node.right, k);
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
