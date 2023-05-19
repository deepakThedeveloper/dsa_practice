package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxDepth {
    public static void main(String[] args) {
        Node leaf2 = new Node(55);
        Node leaf1 = new Node(4);
        Node leaf3 = new Node(6);
        Node leaf4 = new Node(17);
        Node mid1 = new Node(9);
        Node mid4 = new Node(33);
        mid1.left = mid4;
        mid4.right = leaf2;
        Node mid2 = new Node(5, leaf1, mid1);
        Node mid3 = new Node(3, leaf3, leaf4);

        Node root = new Node(10, mid2, mid3);

        System.out.println("Iteration************************");
        System.out.println();
        int maxDepth = findMaxDepth(root);
        System.out.println("max Depth:"+ maxDepth);
    }

    private static int findMaxDepth(Node node) {
        if(node == null) return 0;

        return Math.max(findMaxDepth(node.left), findMaxDepth(node.right)) + 1;
    }
}
