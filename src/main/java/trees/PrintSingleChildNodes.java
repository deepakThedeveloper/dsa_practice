package trees;


// print nodes whose parents have single child
public class PrintSingleChildNodes {
    public static void main(String[] args) {
        Node root = getNode();
        printSingleChildNodes(root);
    }

    private static Node printSingleChildNodes(Node root) {
        if(root == null) return null;

        Node leftNode = printSingleChildNodes(root.left);
        Node rightNode = printSingleChildNodes(root.right);
        if(leftNode == null && rightNode != null) {
            System.out.print(root.right.val+" ");
        }
        else if(rightNode == null && leftNode!=null){
            System.out.print(root.left.val+" ");
        }
        return root;
    }

    private static Node getNode() {
        Node node13 = new Node(64);
        Node node12 = new Node(63, null, node13);
        Node node11 = new Node(62);
        Node node10 = new Node(60);
        Node node9 = new Node(40);
        Node node8 = new Node(70,null , node12);
        Node node7 = new Node(30);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node10, node8 );
        Node node4 = new Node(37, node7, node9);
        Node node3 = new Node(12, node11, null);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(25, node3, node4);
        Node root = new Node(50, node1, node2);

        return root;
    }
}
