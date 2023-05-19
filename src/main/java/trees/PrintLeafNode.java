package trees;

public class PrintLeafNode {
    public static void main(String[] args) {
        Node root = getValidNode();

        printLeafNodes(root);
    }

    private static void printLeafNodes(Node node) {
        if(node == null){
            return;
        }

        printLeafNodes(node.left);
        printLeafNodes(node.right);

        if(node.left==null && node.right==null){
            System.out.println(node.val);
        }
    }

    private static Node getValidNode() {
        Node node7 = new Node(54);
        Node node6 = new Node(2);
        Node node5 = new Node(1, null, node6);
        Node node4 = new Node(15);
        Node node3 = new Node(3, node5, null);
        Node node2 = new Node(80, node7, null);
        Node node1 = new Node(10, node3, node4);
        Node root = new Node(50, node1, node2);

        return root;
    }
}

