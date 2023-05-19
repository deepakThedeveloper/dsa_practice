package trees;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        pathFinder(node, 6, new ArrayList<>());

        System.out.println(pathCount);
    }
    static int pathCount = 0;

    private static void pathFinder(BinaryTreeNode node, int k, List<Integer> path){
        if(node == null) return;
        path.add(node.data);
        pathFinder(node.left, k, path);
        pathFinder(node.right, k, path);

        int sum = 0;
        for(int i=path.size()-1; i>=0; i--){
            sum += path.get(i);
            if(sum == k){
                pathCount++;
            }
        }
        path.remove(path.size()-1);
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode root1 = new BinaryTreeNode(2);
        BinaryTreeNode root2 = new BinaryTreeNode(3);
        BinaryTreeNode root3 = new BinaryTreeNode(4);
        BinaryTreeNode root4 = new BinaryTreeNode(5);
        BinaryTreeNode root5 = new BinaryTreeNode(6);
        BinaryTreeNode root6 = new BinaryTreeNode(7);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root3);
        root3.setRight(root6);
        root2.setLeft(root4);
        root2.setRight(root5);

        return root;
    }

}
