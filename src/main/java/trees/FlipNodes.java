package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/description/
public class FlipNodes {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        flipMatchVoyage(node, new int[]{1,3,4,5,2});

    }
    public static List<Integer> flipMatchVoyage(BinaryTreeNode root, int[] voyage) {
        List<Integer> nodes = new ArrayList<>();
        boolean isFlipped = flip(root, voyage, nodes);

        return isFlipped ? nodes : Arrays.asList(-1);
    }

    static int i=0;
    private static boolean flip(BinaryTreeNode node, int[] voyage, List<Integer> flipNodes){
        if(node == null) return true;

        if(node.data != voyage[i++]) return false;
        if(node.left != null && node.left.data != voyage[i]){
            flipNodes.add(node.data);
            return flip(node.right, voyage, flipNodes) && flip(node.left, voyage, flipNodes);
        }
        return flip(node.left, voyage, flipNodes) && flip(node.right, voyage, flipNodes);
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode root1 = new BinaryTreeNode(2);
        BinaryTreeNode root2 = new BinaryTreeNode(3);
        BinaryTreeNode root3 = new BinaryTreeNode(4);
        BinaryTreeNode root4 = new BinaryTreeNode(5);

        root.setLeft(root1);
        root.setRight(root2);
        root2.setLeft(root3);
        root2.setLeft(root4);

        return root;
    }

}
