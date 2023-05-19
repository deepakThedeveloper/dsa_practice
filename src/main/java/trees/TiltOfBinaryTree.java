package trees;


public class TiltOfBinaryTree {
    public static void main(String[] args) {
        Node node2 = new Node(40);
        Node node3 = new Node(30);
        Node node4 = new Node(20);
        Node node1 = new Node(10, node3, node4);
        Node root = new Node(50, node1, node2);

 /*       int leftSum = findTilt(root.left);
        int rightSum = findTilt(root.right);

        int tilt = Math.abs(leftSum-rightSum);
        System.out.println(tilt);
 */
        findTiltBetterApproach(root);
        System.out.println(tilt);
    }

    private static int findTilt(Node root) {
        if(root == null) return 0;

        return findTilt(root.left)+findTilt(root.right)+ root.val;
    }

    static int tilt;
    private static int findTiltBetterApproach(Node root) {
        if(root == null) return 0;

        int leftSum = findTiltBetterApproach(root.left);
        int rightSum = findTiltBetterApproach(root.right);

        tilt = Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
