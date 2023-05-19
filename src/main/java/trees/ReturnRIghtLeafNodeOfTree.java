package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReturnRIghtLeafNodeOfTree {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        printRightLeafNode(root);

        List<Node1> maxValue = returnRightLeafNode(root);
        maxValue.forEach(v-> System.out.print(v.value+" "));
    }

    private static void printRightLeafNode(Node1 root) {
        for(Node1 child : root.children){
            if(!child.children.isEmpty()){
                System.out.print(child.children.get(child.children.size()-1).value+" ");
            }
            printRightLeafNode(child);
        }
    }

    // expectations: to visit all nodes in tree and return max value
    // faith: printTree(20), printTree(30), printTree(40) return me max value in their tree.
    // ef: I need compare maxValue returned by every child with root max value and save the node in max whose value is biger.
    // e.g; max = max(findMaxValueNode(10).value > findMaxValueNode(20).value)
    private static List<Node1> returnRightLeafNode(Node1 root) {
        List<Node1> node1s = new ArrayList<>();
        for(Node1 child : root.children){
            if(!child.children.isEmpty()){
                node1s.add(child.children.get(child.children.size()-1));
            }
            printRightLeafNode(child);
        }
        return node1s;
    }

    private static Node1 getRootNode() {
        Node1 c222 = new Node1(120);
        Node1 c221 = new Node1(110);
        Node1 c31 = new Node1(100);
        Node1 c23 = new Node1(90);
        Node1 c22 = new Node1(80,Arrays.asList(c221,c222));
        Node1 c21 = new Node1(710);
        Node1 c12 = new Node1(60);
        Node1 c11 = new Node1(50);
        Node1 c3 = new Node1(40, Arrays.asList(c31));
        Node1 c2 = new Node1(30, Arrays.asList(c21,c22,c23));
        Node1 c1 = new Node1(20,Arrays.asList(c11,c12));
        Node1 root = new Node1(10, Arrays.asList(c1,c2,c3));

        return root;
    }
}
