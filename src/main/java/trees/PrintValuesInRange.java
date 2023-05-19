package trees;

public class PrintValuesInRange {
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
        Node node1 = new Node(27, node3, node4);
        Node root = new Node(50, node1, node2);

        printValuesInRange(root, 27, 75);
    }

    private static void printValuesInRange(Node node, int k1, int k2) {
        if(node == null) return;

        if(node.val>=k1){
            if(node.val>k1) {
                printValuesInRange(node.left, k1, k2);
            }
            System.out.print(node.val+" ");
        }
        if(node.val <=k2){
            printValuesInRange(node.right, k1, k2);
        }
    }
}
