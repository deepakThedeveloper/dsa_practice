package priorityQueue;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class PlayWithTree {
    public static void main(String[] args) {

        //getLastLeafNodeOfMaxHeap();
        //getHeight();
        //findTotalNodes();
        replaceValue();
        //findValueBasedOnIndex(4);
    }

    private static void replaceValue() {
        Node root = getNodeForHeight();
        System.out.println("preorder display before replacing");
        root.preorderDisplay(root);
        System.out.println();

        /*boolean valueReplaced = replaceFirstMatchValueInTree(root, 26,21);
        System.out.println("value replaced:"+ valueReplaced);*/

        replaceAllMatchingValueInTree(root, 6,21);

        System.out.println("preorder display after replacing");
        root.preorderDisplay(root);
        System.out.println();
    }

    private static boolean replaceFirstMatchValueInTree(Node root, int from, int to) {
        if(root == null) return false;
        if(root.val == from){
            root.val = to;
            return true;
        }
        boolean leftReplaced = replaceFirstMatchValueInTree(root.left, from, to);
        if(leftReplaced) return leftReplaced;
        boolean rightReplaced = replaceFirstMatchValueInTree(root.right, from, to);
        if(rightReplaced) return rightReplaced;
        return false;
    }

    private static void replaceAllMatchingValueInTree(Node root, int from, int to) {
        if(root == null) return;
        if(root.val == from){
            root.val = to;
        }
         replaceAllMatchingValueInTree(root.left, from, to);
         replaceAllMatchingValueInTree(root.right, from, to);
    }

    private static void findTotalNodes() {
        Node root = getNodeForNodeCount();
        System.out.println("preorder display");
        root.preorderDisplay(root);

        System.out.println();
        System.out.println("total nodes:"+totalNodeCount(root));
    }

    private static Node getNodeForNodeCount() {
        Node leaf1 = new Node(9);
        Node leaf2 = new Node(8);
        Node leaf4 = new Node(4);
        Node leaf6 = new Node(7);
        Node leaf5 = new Node(6);
        leaf5.left = new Node(1);
        Node leaf8 = new Node(0);
        Node leaf9 = new Node(-1);
        Node leaf10 = new Node(-2);
        leaf5.right = leaf8;
        leaf8.right = leaf9;
        leaf9.left = leaf10;
        Node leaf7 = new Node(10);

        leaf2.left = new Node(1);

        /*Node parent1 = new Node(14);
        parent1.left = leaf1;
        parent1.right = leaf2;*/

        Node parent2 = new Node(11);
        parent2.left = leaf6;
        parent2.right = leaf5;

        Node parent5 = new Node(12);
        parent5.left = leaf4;


        Node parent3 = new Node(13);
        parent3.left = parent5;
        parent3.right = leaf7;

        Node parent4 = new Node(15);
       // parent4.left = parent1;
        parent4.right = parent2;

        Node root = new Node(17);
        root.left = parent4;
        root.right = parent3;
        return root;
    }

    private static int totalNodeCount(Node root) {
        if(root == null) return 0;
        int leftCount = totalNodeCount(root.left);
        int rightCount = totalNodeCount(root.right);

        return leftCount + rightCount + 1;
    }

    private static void findValueBasedOnIndex(int index) {
        Node root = getNodeForHeight();
        System.out.println("preorder display");
        root.preorderDisplay(root);
        System.out.println();

        System.out.println("value on index:"+ index +" is "+ findValueOnIndex(root));
    }

    private static int findValueOnIndex(Node root) {
        return 0;
    }

    private static void getLastLeafNodeOfMaxHeap() {
        Node root = getNodeForMaxHeap();
        System.out.println("preorder display");
        root.preorderDisplay(root);

        Node leafNode = findLastLeafNode(root);
        System.out.println("Last Leaf Node:"+leafNode.val);
    }

    private static void getHeight() {
        Node root = getNodeForHeight();
        System.out.println("preorder display");
        root.preorderDisplay(root);

        System.out.println();
        System.out.println("Height Of Tree:"+heightOfTree(root, 0));
    }


    private static Node getNode() {
        Node leaf1 = new Node(9);
        Node leaf2 = new Node(8);
        Node leaf3 = new Node(15);
        Node leaf4 = new Node(17);
        Node leaf5 = new Node(13);
        Node leaf6 = new Node(10);
        Node parent1 = new Node(4);
        parent1.left = leaf1;
        parent1.right = leaf2;
        Node parent2 = new Node(6);
        parent2.left = leaf3;
        parent2.right = leaf4;
        Node parent3 = new Node(5);
        parent3.left = null;
        parent3.right = null;
        Node parent4 = new Node(3);
        parent4.left = parent1;
        parent4.right = parent2;
        Node root = new Node(1);
        root.left = parent4;
        root.right = null;
        return root;
    }

    private static Node getNodeForMaxHeap() {
        Node leaf1 = new Node(9);
        Node leaf2 = new Node(8);
        Node leaf4 = new Node(4);
        Node leaf6 = new Node(7);
        Node leaf5 = new Node(6);
        Node leaf7 = new Node(10);

        Node parent1 = new Node(14);
        parent1.left = leaf1;
        parent1.right = leaf2;

        Node parent2 = new Node(11);
        parent2.left = leaf6;
        parent2.right = leaf5;

        Node parent5 = new Node(12);
        parent5.left = leaf4;


        Node parent3 = new Node(13);
        parent3.left = parent5;
        parent3.right = leaf7;

        Node parent4 = new Node(15);
        parent4.left = parent1;
        parent4.right = parent2;

        Node root = new Node(17);
        root.left = parent4;
        root.right = parent3;
        return root;
    }
    private static Node getNodeForHeight() {
        Node leaf1 = new Node(9);
        Node leaf2 = new Node(8);
        Node leaf4 = new Node(4);
        Node leaf6 = new Node(7);
        Node leaf5 = new Node(6);
        leaf5.left = new Node(1);
        Node leaf8 = new Node(0);
        Node leaf9 = new Node(-1);
        Node leaf10 = new Node(6);
        leaf5.right = leaf8;
        leaf8.right = leaf9;
        leaf9.left = leaf10;
        Node leaf7 = new Node(10);

        leaf2.left = new Node(1);
        
        Node parent1 = new Node(6);
        parent1.left = leaf1;
        parent1.right = leaf2;

        Node parent2 = new Node(11);
        parent2.left = leaf6;
        parent2.right = leaf5;

        Node parent5 = new Node(12);
        parent5.left = leaf4;


        Node parent3 = new Node(13);
        parent3.left = parent5;
        parent3.right = leaf7;

        Node parent4 = new Node(15);
        parent4.left = parent1;
        parent4.right = parent2;

        Node root = new Node(17);
        root.left = parent4;
        root.right = parent3;
        return root;
    }

    //Todo: to be done.
    private static Node findLastLeafNode(Node root) {
        if (root == null) return null;
        Node rightNode =  findLastLeafNode(root.right);
        Node leftNode = root.left != null ? root.left : null;

        return leftNode == null && rightNode == null ? root : leftNode;
    }

    private static int heightOfTree(Node root, Integer height){
        if(root == null) return height-1;
        height++;
        int leftHeight = heightOfTree(root.left, height);
        int rightHeight = heightOfTree(root.right, height);
        int maxVal = Math.max(leftHeight, rightHeight);
        return  maxVal== 0 ? height : maxVal;
    }

    @AllArgsConstructor
    @Getter
    class Values{
        int height;
        int val;
    }
}
