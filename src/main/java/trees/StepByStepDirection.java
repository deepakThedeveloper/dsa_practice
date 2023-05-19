package trees;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
public class StepByStepDirection {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);

        String str = getDirections(node, 3, 6);
        System.out.println(str);
    }
    public static String getDirections(BinaryTreeNode root, int startValue, int destValue) {
        List<String> sourcePath = new ArrayList<>();
        List<String> endPath = new ArrayList<>();

        paths(root, sourcePath, startValue,"");
        paths(root, endPath, destValue,"");

        int minLength = Math.min(sourcePath.size(), endPath.size());

        int ci = 0;
        for(int i=0; i<minLength; i++){
            if(sourcePath.get(i).equals(endPath.get(i))){
                ci++;
            }
            else{
                break;
            }
        }
        StringBuilder end = new StringBuilder();
        for(int i=ci; i<endPath.size(); i++){
            end.append(endPath.get(i));
        }
        StringBuilder start = new StringBuilder();
        for(int i=ci; i<sourcePath.size(); i++){
            start.append("U");
        }
        return start.toString() + end.toString();
    }

    private static BinaryTreeNode paths(BinaryTreeNode node, List<String> sb, int k, String v){
        if(node == null) return null;
        if(v!="")
            sb.add(v);

        if(node.data == k){
            return node;
        }
        BinaryTreeNode left = paths(node.left, sb, k, "L");
        if(left != null){
            return left;
        }
        BinaryTreeNode right = paths(node.right, sb, k, "R");
        if(right != null){
            return right;
        }
        sb.remove(sb.size()-1);
        return null;
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root4 = new BinaryTreeNode(6);
        BinaryTreeNode root5 = new BinaryTreeNode(4);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root3);
        root2.setLeft(root4);
        root2.setRight(root5);

        return root;
    }
}
