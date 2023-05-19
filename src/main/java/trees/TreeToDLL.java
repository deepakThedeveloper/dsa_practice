package trees;

import javafx.util.Pair;

public class TreeToDLL {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);
        toDLL(node);

        BinaryTreeNode temp = node;
        while (node!=null){
            System.out.print(node.data+"-->");
            temp = node;
            node = node.right;
        }

        System.out.println("=====================");
        node = temp;
        while (node!=null){
            System.out.print(node.data+"-->");
            node = node.left;
        }
    }

    static BinaryTreeNode prev=null;
    private static void toDLL(BinaryTreeNode node) {
        if(node == null)return;
        toDLL(node.getLeft());

        node.left = prev;
        if(prev!=null){
            prev.right = node;
        }
        prev = node;

        toDLL(node.getRight());
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode mid6 = new BinaryTreeNode(6);
        BinaryTreeNode mid7 = new BinaryTreeNode(7);
        BinaryTreeNode mid8 = new BinaryTreeNode(8);
        BinaryTreeNode mid9 = new BinaryTreeNode(9);
        BinaryTreeNode mid5 = new BinaryTreeNode(5);
        BinaryTreeNode mid4 = new BinaryTreeNode(4);
        BinaryTreeNode mid2 = new BinaryTreeNode(2);
        BinaryTreeNode mid3 = new BinaryTreeNode(3);
        BinaryTreeNode root = new BinaryTreeNode(1);

        mid5.left = mid6;
        mid5.right = mid7;
        mid4.left = mid8;
        mid4.right = mid9;
        mid3.left = mid4;
        mid3.right = mid5;
        root.left = mid2;
        root.right = mid3;

        return root;
    }
}
