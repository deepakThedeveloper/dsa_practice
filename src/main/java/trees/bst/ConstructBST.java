package trees.bst;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

public class ConstructBST {
    public static void main(String[] args) {
        int[] preorderNodeValues = {30, 20, 10, 15, 25, 23, 39, 35, 42};
        BinaryTreeNode preorderRoot = bstFromPreorder(0, preorderNodeValues.length-1, preorderNodeValues);
        BinaryTreePrinter.print(preorderRoot);


        System.out.println("=========================================");
        int[] inorderNodeValues = {10, 15, 20, 23, 25, 30, 35, 39, 42};
        BinaryTreeNode inorderRoot = bstFromInorder(0, inorderNodeValues.length-1, inorderNodeValues);
        BinaryTreePrinter.print(inorderRoot);
//
//        System.out.println("=========================================");
//        int[] postOrderNodeValues = {15, 10, 23, 25, 20, 35, 42, 39, 30};
//        BinaryTreeNode postorderRoot = bstFromPostorder(0, postOrderNodeValues.length-1, postOrderNodeValues);
//        BinaryTreePrinter.print(postorderRoot);
    }

    private static BinaryTreeNode bstFromPreorder(int s, int e, int[] a){
        if(s>e)return null;

        BinaryTreeNode root = new BinaryTreeNode(a[s]);

        int i=s+1;
        while(i<=e){
            if(a[i]>a[s]) break;
            i++;
        }
        root.setLeft(bstFromPreorder(s+1, i-1, a));
        root.setRight(bstFromPreorder(i, e, a));

        return root;
    }

    private static BinaryTreeNode bstFromInorder(int s, int e, int[] a){
        if(s>e)return null;

        int mid = (s+e)/2;
        BinaryTreeNode root = new BinaryTreeNode(a[mid]);

        root.setLeft(bstFromInorder(s, mid-1, a));
        root.setRight(bstFromInorder(mid+1, e, a));

        return root;
    }

    //todo: answer incorrect
    private static BinaryTreeNode bstFromPostorder(int s, int e, int[] a){
        if(s>e)return null;

        BinaryTreeNode root = new BinaryTreeNode(a[e]);

        int i=e-1;
        while(i>=s){
            if(a[i]<a[s]) break;
            i--;
        }
        root.setRight(bstFromPreorder(i+1, e-1, a));
        root.setLeft(bstFromPreorder(s, i, a));
        return root;
    }
}
