package trees;


import java.util.LinkedList;
import java.util.Queue;

// to find, number of nodes, sum, height, max node
public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = getNode();
        queue.add(root);
        traverseTreeLevelOrder(root);
    }

    static Queue<Node> queue = new LinkedList<>();
    private static void traverseTreeLevelOrder(Node root) {
        if(root == null) return;
        while(!queue.isEmpty()){
            Node val = queue.poll();
            if(val == null) return;
            System.out.print(val.val+" ");

            queue.add(val.left);
            queue.add(val.right);

            traverseTreeLevelOrder(val.left);
            traverseTreeLevelOrder(val.right);
        }

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
