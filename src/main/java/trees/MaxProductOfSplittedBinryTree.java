package trees;

public class MaxProductOfSplittedBinryTree {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        int sum = sumOfAllNodes(node);
        int modulo = 1000000007;
        maxProduct(node, sum);
        maxProduct = maxProduct % modulo;
    }

    private static int sumOfAllNodes(BinaryTreeNode node){
        if(node==null) return 0;

        return sumOfAllNodes(node.left) + sumOfAllNodes(node.right) + node.data;
    }

    static long maxProduct = 0;
    private static long maxProduct(BinaryTreeNode node, int sum){
        if(node == null) return 0;
        long left = maxProduct(node.left, sum);
        long right = maxProduct(node.right, sum);

        long subtreeSum = left + right + node.data;
        maxProduct = Math.max((sum-subtreeSum)*subtreeSum, maxProduct);

        return subtreeSum;
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
