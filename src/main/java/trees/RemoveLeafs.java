package trees;


public class RemoveLeafs {
    public static void main(String[] args) {
        Node root = getNode();
        Traversal.preorderTraversal(root);
        System.out.println(" better code");
        removeLeafsBetterCode(root);
        Traversal.preorderTraversal(root);
    }

    private static Node removeLeafsBetterCode(Node root) {
        if(root.left == null && root.right == null) return null;
        root.left = removeLeafsBetterCode(root.left);
        root.right = removeLeafsBetterCode(root.right);

        return root;
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
