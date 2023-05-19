package trees;

// every parent value should be sum of its child. e.g.: Parent(A) = sum(Child1, Child2).
//if there is a mismatch then make it equal by adding +1 to either child or parent
public class ChildrenSumProperty {

    public static void main(String[] args) {
        Node node = getTree();
        BFSTraversal bfsTraversal = new BFSTraversal();
        System.out.println("Before computation:");
        BFSTraversal.printBFS(node);

        cSPTree(node, 0);

        System.out.println("After computation:");
        BFSTraversal.printBFS(node);
    }

    private static int cSPTree(Node node, int addVal) {
        if(node == null)return 0;

        if(node.val<addVal){
            node.val = addVal;
        }
        int left = cSPTree(node.left, node.val);
        int right = cSPTree(node.right, node.val);

        int sum = left + right;
        if(node.val < sum){
            node.val = sum;
        }
        return node.val;

    }

    private static Node getTree(){
        Node mid8 = new Node(30);
        Node mid9 = new Node(1);
        Node mid5 = new Node(5);
        Node mid4 = new Node(300);
        Node mid2 = new Node(7, mid4, mid5);

        Node mid3 = new Node(2, mid9, mid8);
        Node root = new Node(50, mid2, mid3);

        return root;
    }
}


