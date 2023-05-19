package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
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
        printBFS(root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println();
        System.out.println("Recursion*************************");
        System.out.println();
        printBFSRecursion(queue);
    }

    public static void printBFS(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            Node temp = nodeQueue.poll();
            Node left = temp.left;
            Node right = temp.right;

            if(left != null){
                nodeQueue.add(left);
            }
            if(right!=null){
                nodeQueue.add(right);
            }

            System.out.print(temp.val+" ");
        }
    }

    private static void printBFSRecursion(Queue<Node> nodeQueue) {
        if(nodeQueue.isEmpty()){
            return;
        }
        Node temp = nodeQueue.poll();
        System.out.print(temp.val+" ");
        Node left = temp.left;
        Node right = temp.right;

        if(left != null){
            nodeQueue.add(left);
        }
        if(right!=null){
            nodeQueue.add(right);
        }
        printBFSRecursion(nodeQueue);
    }
}
