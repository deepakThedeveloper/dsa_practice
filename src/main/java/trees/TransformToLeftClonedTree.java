package trees;


// between every parent node and its left child add another parent node with same val.
public class TransformToLeftClonedTree {
    public static void main(String[] args) {
        Node root = getNode();
        System.out.println("before clone");
        Traversal.preorderTraversal(root);

        transformToLeftClonedTree(root);
        System.out.println();
        System.out.println("after clone");
        Traversal.preorderTraversal(root);

        System.out.println();
        System.out.println("transform back from clone to normal tree");
        transformCloneToNormal(root);
        Traversal.preorderTraversal(root);
    }

    private static void transformCloneToNormal(Node root) {
        if(root == null) return;
        root.left = root.left.left;
        transformCloneToNormal(root.left);
        transformCloneToNormal(root.right);
    }

    private static void transformToLeftClonedTree(Node root) {
        if(root == null) return;

        transformToLeftClonedTree(root.left);
        transformToLeftClonedTree(root.right);
        Node node1 = new Node(root.val);
        node1.left = root.left;
        root.left = node1;
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
