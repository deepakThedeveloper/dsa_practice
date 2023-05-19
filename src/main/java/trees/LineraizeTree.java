package trees;

import java.util.ArrayList;
import java.util.Arrays;

// Linearize means every node has a single node only.
public class LineraizeTree {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        lineraizeTree(root);
        DisplayTree.printTree(root);
    }

    // expectations: to visit all nodes in tree assign only one child to every node.
    // if a node has many children then next children to last leaf node of previous children. e,g: 30 will be assigned to 60
    // faith: 20, 30, 40 have already linearized their tree
    //TOdo: to optimize solution as currently it is n^2.
    private static void lineraizeTree(Node1 root) {
        for(Node1 child : root.children){
            lineraizeTree(child);
        }
        while (root.children.size() > 1){
            Node1 lastChild = root.children.remove(root.children.size()-1);
            Node1 secondLastChild = root.children.get(root.children.size()-1);

            Node1 tail = getTail(secondLastChild);
            tail.children = Arrays.asList(lastChild);
        }
    }

    private static Node1 getTail(Node1 node1) {
        while(node1.children.size() == 1){
            node1 = node1.children.get(0);
        }
        return node1;
    }

    private static Node1 getRootNode() {
        Node1 c222 = new Node1(120);
        Node1 c221 = new Node1(110);
        Node1 c31 = new Node1(100);
        Node1 c23 = new Node1(90);
        Node1 c22 = new Node1(80,new ArrayList<>(Arrays.asList(c221,c222)));
        Node1 c21 = new Node1(70);
        Node1 c12 = new Node1(60);
        Node1 c11 = new Node1(50);
        Node1 c3 = new Node1(40, new ArrayList<>(Arrays.asList(c31)));
        Node1 c2 = new Node1(30, new ArrayList<>(Arrays.asList(c21,c22,c23)));
        Node1 c1 = new Node1(20,new ArrayList<>(Arrays.asList(c11,c12)));
        Node1 root = new Node1(10, new ArrayList<>(Arrays.asList(c1,c2,c3)));

        return root;
    }
}
