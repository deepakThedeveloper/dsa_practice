package trees;

public class MinCamerasInTree {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        minCameras(node);
        System.out.println(min);
    }

    // -1 : we need camera
    // 0: i own camera
    // 1: I don't own camera as I am covered

    static int min = 0;
    private static int minCameras(BinaryTreeNode node){
        if(node == null) return 1;

        int leftState = minCameras(node.left);
        int rightState = minCameras(node.right);

        if(leftState == -1 || rightState == -1){
            min += 1;
            return 0;
        }
        if(leftState == 0 || rightState == 0){
            return 1;
        }
        return -1;
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
        BinaryTreeNode root12 = new BinaryTreeNode(9);
        BinaryTreeNode root13 = new BinaryTreeNode(10);
        BinaryTreeNode root14 = new BinaryTreeNode(11);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root4);
        root1.setRight(root5);
        root2.setLeft(root6);
        root2.setRight(root7);
        root5.setLeft(root10);
        root10.setRight(root11);
        root11.setLeft(root8);
        root11.setRight(root9);
        root7.setLeft(root12);
        root7.setRight(root13);
        root13.setLeft(root14);

        return root;
    }
}
