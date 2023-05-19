package trees;

import java.util.Arrays;

public class TraversalTest {
    public static void main(String[] args) {
        Node1 node12 = new Node1(30);
        Node1 node1 = new Node1(20);
        Node1 root = new Node1(10, Arrays.asList(node1, node12));

        traverse(root);
    }

    private static void traverse(Node1 root) {
        if(root.children.isEmpty()) return;
        for(Node1 child : root.children){
            traverse(child);
        }
        System.out.println(root.value);
    }
}
