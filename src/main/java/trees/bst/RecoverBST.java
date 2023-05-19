package trees.bst;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class RecoverBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);

        isValidBST(node);
        System.out.println(first);
        System.out.println(middle);
        System.out.println(last);

        if(first!=null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        else if(first!=null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
        BinaryTreePrinter.print(node);

    }

    static BinaryTreeNode prev = new BinaryTreeNode(Integer.MIN_VALUE);
    static BinaryTreeNode first;
    static BinaryTreeNode middle;
    static BinaryTreeNode last;
    private static void isValidBST(BinaryTreeNode node) {
        if(node == null) return;
        isValidBST(node.getLeft());
        if(prev != null && node.getData() < prev.data){
            if(first == null) {
                first = prev;
                middle = node;
            }
            else {
                last = node;
            }
        }
        prev = node;
        isValidBST(node.getRight());
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode node0= new BinaryTreeNode(8);
        BinaryTreeNode node1= new BinaryTreeNode(12);
        BinaryTreeNode node2= new BinaryTreeNode(5);
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
