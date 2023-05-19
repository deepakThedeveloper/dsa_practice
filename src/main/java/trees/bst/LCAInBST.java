package trees.bst;

import lombok.AllArgsConstructor;
import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class LCAInBST {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);
        int lca = lca(node, 4, 15);
        System.out.println(lca);
    }

    private static int lca(BinaryTreeNode node, int k1, int k2){
        if(node == null) return -1;
        if(k1 < node.data && k2 < node.data) {
            return lca(node.getLeft(), k1, k2);
        }
        else if(k1 > node.data && k2 > node.data){
            return lca(node.getRight(), k1, k2);
        }
        return node.getData();
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
