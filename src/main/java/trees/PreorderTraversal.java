package trees;

import java.util.Arrays;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) {
        Node1 node1 = getRootNode();

        traversePreorderIteratively(node1);
    }

    private static void traversePreorderIteratively(Node1 node1) {
        Stack<Node1> node1s = new Stack<>();
        Stack<Integer> index = new Stack<>();

        node1s.add(node1);
        index.add(0);

        while (!node1s.isEmpty()) {
            int i = index.pop();
            if(i > 0){
                node1 = node1s.peek();
                index.add(i-1);
            }
            else{
                node1 = node1s.pop();
            }
            for (; i < node1.children.size(); ) {
                node1s.add(node1.children.get(i));
                index.add(i);
                node1 = node1.children.get(i);
                i=0;
            }
            System.out.print(node1.value+" ");
        }
    }

    private static Node1 getRootNode() {
        Node1 node1 = new Node1(60);
        Node1 node12 = new Node1(50);
        Node1 node13 = new Node1(40);
        Node1 node14 = new Node1(30, Arrays.asList(node12,node1));
        Node1 node15 = new Node1(20);
        Node1 root = new Node1(10, Arrays.asList(node13, node14, node15));

        return root;
    }
}
