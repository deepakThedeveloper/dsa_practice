package trees;

import java.util.Arrays;

//output should be
/*
10 -> 20,30,40
20 -> 50,60
50 ->
60 ->
30 ->70,80,90
70 ->
80-> 110, 120
90->
40->100
100->

root node printing himself, his family and later same is getting done by his children
 */
public class DisplayTree {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        printTree(root);
    }

    // expectations: to print the parent node, and its children, then on next line print its child node and their children.
    // faith: printTree(20), printTree(30), printTree(40) are capable of printing themselves and their children
    //ef: I just need to 10 and its children and give a call to printTree with 10's children.
    public static void printTree(Node1 root) {
        System.out.print(root.value+" ->");
        for(Node1 child : root.children){
            System.out.print(child.value+", ");
        }
        System.out.println();
        for(Node1 child: root.children){
            printTree(child);
        }
    }

    private static Node1 getRootNode() {
        Node1 c222 = new Node1(120);
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
