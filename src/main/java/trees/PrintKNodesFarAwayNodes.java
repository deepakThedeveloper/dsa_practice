package trees;


import java.util.ArrayList;
import java.util.List;

// to find, number of nodes, sum, height, max node
public class PrintKNodesFarAwayNodes {
    public static void main(String[] args) {
        Node root = getNode();
        List<Node> path = nodeToRootPath(root, 40);
        path.forEach(node -> System.out.print(node.val+" "));
        System.out.println("=================================");
        int k = 3, i=0;
        Node blocker = null;
        for(Node node : path) {
            printNodesKDistanceAwayFromN(root, node.val, k, false, blocker);
            System.out.println();
            k--;
            blocker = path.get(i);
            i++;
        }
    }

    private static void printNodesKDistanceAwayFromN(Node root, int n, int k, boolean found, Node blocker) {
        if(root == null || root == blocker) return;
        if(k==0){
            System.out.print(root.val+" ");
            return;
        }
        if(root.val == n || found){
            printNodesKDistanceAwayFromN(root.left, n,k-1, true, blocker);
            printNodesKDistanceAwayFromN(root.right, n, k-1, true, blocker);
        }
        else{
            printNodesKDistanceAwayFromN(root.left, n, k, false, blocker);
            printNodesKDistanceAwayFromN(root.right, n, k, false, blocker);
        }
    }

    private static List<Node> nodeToRootPath(Node root, int k) {
        if(root == null){
            return new ArrayList<>();
        }
        if(root.val == k){
            List<Node> paths = new ArrayList<>();
            paths.add(root);
            return paths;
        }
        List<Node> leftPath = nodeToRootPath(root.left, k);
        if(!leftPath.isEmpty()){
            leftPath.add(root);
            return leftPath;
        }
        List<Node> rightPath = nodeToRootPath(root.right, k);
        if(!rightPath.isEmpty()){
            rightPath.add(root);
            return rightPath;
        }
        return new ArrayList<>();
    }

    private static Node getNode() {
        Node node25 = new Node(240);
        Node node24 = new Node(230);
        Node node23 = new Node(220);
        Node node22 = new Node(210);
        Node node21 = new Node(200);
        Node node20 = new Node(190, node23, node24);
        Node node19 = new Node(180, null, node25);
        Node node18 = new Node(170);
        Node node17 = new Node(160, node21, node22);
        Node node16 = new Node(150);
        Node node15 = new Node(140);
        Node node14 = new Node(130, node19, node20);
        Node node13 = new Node(120, node17, node18);
        Node node12 = new Node(110);
        Node node11 = new Node(100, node15, node16);
        Node node10 = new Node(60);
        Node node9 = new Node(40, node13, node14);
        Node node8 = new Node(70);
        Node node7 = new Node(30, node11, node12);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node10, node8 );
        Node node4 = new Node(37, node7, node9);
        Node node3 = new Node(12);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(25, node3, node4);
        Node root = new Node(10, node1, node2);

        return root;
    }
}
