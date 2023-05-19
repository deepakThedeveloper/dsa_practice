package trees;

import java.util.Arrays;

public class HeightOfTree {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        int height = findHeightOfTree(root);
        System.out.println(height);
    }

    // expectations: to visit all nodes in tree count the height at every level and return the max number
    // faith: printTree(20), printTree(30), printTree(40) return their height.
    // ef: I need compare height returned by 20, 30 and 40 and which ever is max need to add 1 in that return the heigh
    private static int findHeightOfTree(Node1 root) {
         // initialize this with -1 because imagine if root node has no children. then the height expected is 0,
         // but it would have returned 1. height is defined by total edges a node has and not the node itself.
        // because of this, a root node without any children will have edge 0 so its height will be zero.
        int maxHeight = -1;
        for(Node1 child : root.children){
            int childHeight = findHeightOfTree(child) ;
            maxHeight = Math.max(maxHeight, childHeight);
        }
        return maxHeight + 1;
    }

    private static Node1 getRootNode() {
        Node1 c2221 = new Node1(130);
        Node1 c222 = new Node1(120, Arrays.asList(c2221));
        Node1 c221 = new Node1(110);
        Node1 c31 = new Node1(100);
        Node1 c23 = new Node1(90);
        Node1 c22 = new Node1(80,Arrays.asList(c221,c222));
        Node1 c21 = new Node1(70);
        Node1 c12 = new Node1(60);
        Node1 c11 = new Node1(50);
        Node1 c3 = new Node1(40, Arrays.asList(c31));
        Node1 c2 = new Node1(30, Arrays.asList(c21,c22,c23));
        Node1 c1 = new Node1(20,Arrays.asList(c11,c12));
        Node1 root = new Node1(10, Arrays.asList(c1,c2,c3));

        return root;
    }
}
