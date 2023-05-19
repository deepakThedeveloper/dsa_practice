package trees;


import java.util.ArrayList;
import java.util.List;

// to find, number of nodes, sum, height, max node
public class NodeToRootPath {
    public static void main(String[] args) {
        Node root = getNode();
        List<Node> paths = nodeToRootPath(root, 25);
        paths.forEach(node -> System.out.print(node.val+" "));
    }

    public static List<Node> nodeToRootPath(Node root, int k) {
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

    public static Node getNode() {
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
