package trees;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);
        boolean isEvenOdd = isEvenOddTree(node);

        System.out.println(isEvenOdd);
    }

    public static boolean isEvenOddTree(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0; i<size; i++){
                BinaryTreeNode curr = queue.poll();
                BinaryTreeNode next = queue.peek();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);

                if(level==0 && curr.data%2==0) return false;

                if(level%2==0){
                    if(curr.data%2==0 || (i<size-1 && curr.data>=next.data)) return false;
                }
                else{
                    if(curr.data%2!=0 || (i<size-1 && curr.data<=next.data)) return false;
                }
            }
        }
        return true;
    }
    private static BinaryTreeNode getTree(){
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root7 = new BinaryTreeNode(7);
        BinaryTreeNode root8 = new BinaryTreeNode(8);
        BinaryTreeNode root9 = new BinaryTreeNode(9);
        BinaryTreeNode root10 = new BinaryTreeNode(10);
        BinaryTreeNode root11 = new BinaryTreeNode(11);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root4);
        root1.setRight(root5);
        root2.setLeft(root6);
        root2.setRight(root7);
        root4.setLeft(root8);
        root4.setRight(root9);
        root5.setLeft(root10);
        root5.setRight(root11);

        return root;
    }
}
