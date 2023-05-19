package trees;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Node root = getNode();

        Data data = findDiameterOfTree(root);
        System.out.println(data.longest);

    }

    @AllArgsConstructor
    @NoArgsConstructor
     static class Data{
        int longest;
        int deepest;
    }
    private static Data findDiameterOfTree(Node root) {
        if(root == null) return new Data(0, -1);
        Data leftData = findDiameterOfTree(root.left);
        Data rightData = findDiameterOfTree(root.right);

        int temp = leftData.deepest + rightData.deepest +2;
        int rootDeepest  = Math.max(leftData.deepest, rightData.deepest)+1;
        int rootLongest  = Math.max(temp, Math.max(leftData.longest, rightData.longest));
        return new Data(rootLongest, rootDeepest);
    }

    private static Node getNode() {
        Node node15 = new Node(270);
        Node node14 = new Node(270);
        Node node13 = new Node(270, node14, null);
        Node node12 = new Node(230, node13, null);
        Node node11 = new Node(170, node15, null);
        Node node10 = new Node(130, node11, null);
        Node node9 = new Node(187, node10, null);
        Node node8 = new Node(70);
        Node node7 = new Node(30, node12, null);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node8, null);
        Node node4 = new Node(37, node7, null);
        Node node3 = new Node(12, node9, null);
        Node node2 = new Node(175, node5, node6);
        Node node1 = new Node(25, node3, node4);
        Node root = new Node(250, node1, node2);

        return root;
    }
}
