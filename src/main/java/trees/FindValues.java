package trees;


// to find, number of nodes, sum, height, max node
public class FindValues {
    public static void main(String[] args) {
        Node root = getNode();

        /*int totalNodes = findTotalNodes(root);
        System.out.println("total nodes:"+totalNodes);

        int sum = findSumOfAllNodes(root);
        System.out.println("sum:"+sum);*/

        /*int height = findHeightOfTree(root);
        System.out.println("height:"+height);
        */
        int maxNode = findMaxNode(root);
        System.out.println("max node:"+maxNode);

    }

    private static int findMaxNode(Node root) {
        if(root == null) return 0;

        int leftMaxNode = findMaxNode(root.left);
        int rightMaxNode = findMaxNode(root.right);

        int maxNode = Math.max(leftMaxNode, rightMaxNode);
        return Math.max(maxNode, root.val);
    }

    private static int findHeightOfTree(Node root) {
        if(root == null) return 0;

        int leftMaxHeight = findHeightOfTree(root.left);
        int rightMaxHeight = findHeightOfTree(root.right);

        int ht = Math.max(leftMaxHeight, rightMaxHeight);
        return ht+1;
    }

    private static int findSumOfAllNodes(Node root) {
        if(root == null)return 0;

        int leftRightNodesSum = findSumOfAllNodes(root.left) + findSumOfAllNodes(root.right);
        return leftRightNodesSum + root.val;
    }

    private static int findTotalNodes(Node root) {
        if(root == null)return 0;
        int leftRightNodes = findTotalNodes(root.left) + findTotalNodes(root.right);
        return leftRightNodes+1;
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
