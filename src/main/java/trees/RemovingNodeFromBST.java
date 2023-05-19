package trees;

public class RemovingNodeFromBST {
    public static void main(String[] args) {
        Node node14 = new Node(95);
        Node node13 = new Node(15);
        Node node12 = new Node(25, node13, null);
        Node node11 = new Node(90, null, node14);
        Node node10 = new Node(70);
        Node node9 = new Node(60);
        Node node8 = new Node(40);
        Node node7 = new Node(30, node12, null);
        Node node6 = new Node(87, null, node11);
        Node node5 = new Node(62, node9, node10);
        Node node4 = new Node(37, node7, node8);
        Node node3 = new Node(12);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(20, node3, node4);
        Node root = new Node(50, node1, node2);

        System.out.println("preorder traversal before node removal");
        Traversal.preorderTraversal(root);

        int leafNode = 70;
        int nodeWithSingleLeftChild = 25;
        int nodeWithSingleRightChild = 87;
        int nodeWithTwoChild = 20;

//        removeNode(root, leafNode);
//        removeNode(root, nodeWithSingleLeftChild);
//        removeNode(root, nodeWithSingleRightChild);
          removeNode(root, nodeWithTwoChild);

        System.out.println();
        System.out.println("preorder traversal after node removal");
        Traversal.preorderTraversal(root);


    }

    private static Node removeNode(Node root, int k) {
        if(root == null){
            return null;
        }
        if(root.val == k){
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left !=null && root.right!=null){
                Node maxNode = getMaxNodeFromLeft(root.left, root);
                root.val = maxNode.val;
                return root;
            }
            else{
                return root.left!=null ? root.left : root.right;
            }
        }
        if(k>=root.val){
            root.right = removeNode(root.right, k);
        }
        else{
            root.left = removeNode(root.left, k);
        }

        return root;
    }

    private static Node getMaxNodeFromLeft(Node root, Node parent) {
        if(root == null) return null;
        if(root.right !=null) {
            return getMaxNodeFromLeft(root.right, root);
        }
        else{
            if(parent.left == root){
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        return root;
    }
}
