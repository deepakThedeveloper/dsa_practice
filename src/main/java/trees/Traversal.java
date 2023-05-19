package trees;

public class Traversal {
    public static void main(String[] args) {
        Node root = getNode();

        preorderTraversal(root);
    }

    public static void preorderTraversal(Node root) {
        if(root == null) return;
        System.out.print(root.val+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private static Node getNode() {
        Node node8 = new Node(70);
        Node node7 = new Node(30);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node8, null);
        Node node4 = new Node(37, node7, null);
        Node node3 = new Node(12);
        Node node2 = new Node(175, node5, node6);
        Node node1 = new Node(25, node3, node4);
        Node root = new Node(250, node1, node2);

        return root;
    }
}
