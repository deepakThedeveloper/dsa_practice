package trees;

import java.util.LinkedHashMap;
import java.util.Map;

public class TargetSumPair {
    public static void main(String[] args) {
        Node node10 = new Node(70);
        Node node9 = new Node(60);
        Node node8 = new Node(40);
        Node node7 = new Node(30);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node9, node10);
        Node node4 = new Node(37, node7, node8);
        Node node3 = new Node(12);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(25, node3, node4);
        Node root = new Node(50, node1, node2);

        printTargetSumPairs(root, 100);
        set.values().stream().filter(v -> v.length()>1).forEach(System.out::println);
    }

    static Map<Integer, String> set = new LinkedHashMap<>();
    private static void printTargetSumPairs(Node node, int k) {
        if(node == null) return;

        if(set.containsKey(node.val)){
            set.put(node.val,  k-node.val +"-"+node.val);

        }
        else{
            set.put(k-node.val,"a");
        }
        printTargetSumPairs(node.left, k);
        printTargetSumPairs(node.right, k);
    }
}
