package trees;

public class ReplaceNodeValueWithLargerSum {
    public static void main(String[] args) {
        Node node10 = new Node(70);
        Node node9 = new Node(60);
        Node node8 = new Node(40);
        Node node7 = new Node(30);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node9, node10);
        Node node4 = new Node(37, node7, node8);
        Node node3 = new Node(12);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(20, node3, node4);
        Node root = new Node(50, node1, node2);

        System.out.println("preorder traversal before node removal");
        Traversal.preorderTraversal(root);

        replaceValues(root);

        System.out.println();
        System.out.println("preorder traversal after node removal");
        Traversal.preorderTraversal(root);

        System.out.println("Max sum:"+sum);
    }

    static int sum = 0;
    private static void replaceValues(Node root) {

        if(root == null) return;

        replaceValues(root.right);

        int temp = root.val;
        root.val = sum;
        sum += temp;

        replaceValues(root.left);
    }
}
