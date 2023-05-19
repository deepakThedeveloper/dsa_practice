package trees;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node leaf1 = new Node(4);
        Node leaf3 = new Node(6);
        leaf3.left = new Node(60);
        Node leaf4 = new Node(17);
        Node mid1 = new Node(9);
        Node mid4 = new Node(33);
        mid1.left = mid4;
        mid4.right = new Node(55);
        Node mid2 = new Node(5, leaf1, mid1);
        Node mid3 = new Node(3, leaf3, leaf4);

        Node root = new Node(10, mid2, mid3);

        int val = isBalanceBT(root);
        if(val == -1){
            System.out.println("not a balanced binary tree");
        }
        else{
            System.out.println("it is balanced binary tree");
        }
    }

    private static int isBalanceBT(Node node) {
        if(node == null) return 0;

        int leftHeight = isBalanceBT(node.left);
        int rightHeight = isBalanceBT(node.right);

        if((Math.abs(leftHeight - rightHeight) > 1) || leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight)+1;
    }
}
