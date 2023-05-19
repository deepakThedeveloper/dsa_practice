package trees;

import java.util.Arrays;

public class MaximumSumSubtree {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        findNodeWithMaximumSumSubtree(root);
        System.out.println(msn.value);
    }

    static Node1 msn = null;
    static int max = Integer.MIN_VALUE;
    private static int findNodeWithMaximumSumSubtree(Node1 root) {
        int sum = 0;

        for(Node1 child : root.children){
                int csum = findNodeWithMaximumSumSubtree(child);
            sum += csum;
        }
        sum += root.value;
        if(sum>max){
            max = sum;
            msn = root;
        }
        return sum;
    }

    private static Node1 getRootNode() {
        Node1 c222 = new Node1(-120);
        Node1 c221 = new Node1(-110);
        Node1 c31 = new Node1(100);
        Node1 c23 = new Node1(90);
        Node1 c22 = new Node1(80, Arrays.asList(c221,c222));
        Node1 c21 = new Node1(-70);
        Node1 c12 = new Node1(-60);
        Node1 c11 = new Node1(-50);
        Node1 c3 = new Node1(40, Arrays.asList(c31));
        Node1 c2 = new Node1(30, Arrays.asList(c21,c22,c23));
        Node1 c1 = new Node1(20,Arrays.asList(c11,c12));
        Node1 root = new Node1(10, Arrays.asList(c1,c2,c3));

        return root;
    }
}
