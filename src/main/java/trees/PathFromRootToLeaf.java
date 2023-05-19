package trees;


// to find, number of nodes, sum, height, max node
public class PathFromRootToLeaf {
    public static void main(String[] args) {
        Node root = getNode();
        printPathWhoseSumIsBetweenLowHigh(root, 20, 150, "", 0);
    }

    private static void printPathWhoseSumIsBetweenLowHigh(Node root, int lo, int hi, String path, int sum) {
        if(root == null){
            return;
        }
        sum += root.val;
        path = path+"->"+root.val;

        printPathWhoseSumIsBetweenLowHigh(root.left, lo, hi, path, sum);
        printPathWhoseSumIsBetweenLowHigh(root.right, lo, hi, path, sum);

        //sum+= root.val;
        if((sum>lo && sum<=hi) && (root.left == null && root.right == null)){
            //path = path+"->"+root.val;
            System.out.println(path);
        }
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
