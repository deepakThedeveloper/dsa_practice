package trees;

import javafx.util.Pair;

public class SumOfLongestNode {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        BinaryTreePrinter.print(node);

        Pair<Integer, Integer> longestPathSum = longestPathSum(node);
        System.out.println(longestPathSum);
    }

    private static Pair<Integer, Integer> longestPathSum(BinaryTreeNode node) {
        if(node == null){
            return new Pair<>(0, 0);
        }
        Pair<Integer, Integer> pathSumLeft = longestPathSum(node.getLeft());
        Pair<Integer, Integer> pathSumRight = longestPathSum(node.getRight());

        int sum = 0;

        if(pathSumLeft.getKey() > pathSumRight.getKey()){
            sum += pathSumLeft.getValue() + node.data;
        }
        else if (pathSumRight.getKey() > pathSumLeft.getKey()){
            sum += pathSumRight.getValue() + node.data;
        }
        else{
            sum += Math.max(pathSumLeft.getValue(), pathSumRight.getValue()) + node.data;
        }
        int longestPath = Math.max(pathSumLeft.getKey(), pathSumRight.getKey()) + 1;
        return new Pair<>(longestPath, sum);
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode leaf9 = new BinaryTreeNode(0);
        BinaryTreeNode leaf8 = new BinaryTreeNode(0);
        BinaryTreeNode mid3 = new BinaryTreeNode(4);
        BinaryTreeNode mid4 = new BinaryTreeNode(5);
        BinaryTreeNode mid1 = new BinaryTreeNode(2);
        mid1.setLeft(mid3);
        mid1.setRight(mid4);

        BinaryTreeNode mid5 = new BinaryTreeNode(6);
        BinaryTreeNode mid6 = new BinaryTreeNode(7);
        BinaryTreeNode mid2 = new BinaryTreeNode(3);
        BinaryTreeNode mid7 = new BinaryTreeNode(8);
        BinaryTreeNode root = new BinaryTreeNode(1);

        root.setLeft(mid1);
        root.setRight(mid2);
        mid2.setLeft(mid5);
        mid2.setRight(mid6);
        mid4.left = mid7;
        mid5.left = leaf9;
        leaf9.left = leaf8;

        return root;
    }
}
