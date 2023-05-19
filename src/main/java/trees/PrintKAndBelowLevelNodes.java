package trees;


import java.util.LinkedList;
import java.util.Queue;

// print all the nodes of and below k in level order wise
public class PrintKAndBelowLevelNodes {
    public static void main(String[] args) {
        Node root = getNode();
        Queue<Node> queue = traverseTreeLevelOrder(root, 2, 0);
        addAndPrintKLevelNodes(queue, queue.poll());
    }

    private static void addAndPrintKLevelNodes(Queue<Node> queue, Node node) {
        if(node == null) return;;
        System.out.print(node.val+" ");
        queue.add(node.left);
        queue.add(node.right);

        while (!queue.isEmpty()){
            node = queue.poll();

            addAndPrintKLevelNodes(queue, node);
        }
    }

    //static Queue<Node> queue = new LinkedList<>();
    private static Queue<Node> traverseTreeLevelOrder(Node root, int k, int levelCount) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return new LinkedList<>();
        if(levelCount >=k-1){
            Queue<Node> queue1 = new LinkedList<>();
            queue1.add(root.left);
            queue1.add(root.right);
            return queue1;
        }
        Queue<Node> leftQueue =traverseTreeLevelOrder(root.left, k, levelCount+1);
        if(!leftQueue.isEmpty()) queue.addAll(leftQueue);
        Queue<Node> rightQueue =traverseTreeLevelOrder(root.right, k, levelCount+1);
        if(!rightQueue.isEmpty()) queue.addAll(rightQueue);

        return queue;
    }

    private static Node getNode() {
        Node node10 = new Node(60);
        Node node9 = new Node(40);
        Node node8 = new Node(70);
        Node node7 = new Node(30);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node10, node8 );
        Node node4 = new Node(37, node7, node9);
        Node node3 = new Node(12);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(25, node3, node4);
        Node root = new Node(50, node1, node2);

        return root;
    }
}
