package trees;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/smallest-string-starting-from-leaf/
public class LexiographicPath {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);

        String str = smallestFromLeaf(node);
        System.out.println(str);
    }
    public static String smallestFromLeaf(BinaryTreeNode root) {
        return dfs(root);
    }

    private static String dfs(BinaryTreeNode node){
        if(node == null) return null;

        String left = dfs(node.left);
        String right = dfs(node.right);

        String v = Character.toString((char)(node.data + 97));
        if(left == null && right == null) return v;
        if(left == null) return right + v;
        if(right == null) return left + v;

        return lCompare(left+v, right+v);
    }

    private static String lCompare(String s1, String s2){
        System.out.println("s1:"+s1+" s2:"+s2);
        int size = Math.min(s1.length(), s2.length());
        int compare;
        for(int i=0; i<size; i++){
            compare = Character.compare(s1.charAt(i), s2.charAt(i));
            if(compare < 0){
                return s1;
            }
            else if(compare > 0){
                return s2;
            }
        }
        return s1.length() > s2.length() ? s2 : s1;
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
