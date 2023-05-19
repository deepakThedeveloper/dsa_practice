package trees;

import java.util.Arrays;

// two values are given. method needs to return first common ancestor of both value from bottom.
public class TreesMirrorOfEachOther {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        Node1 root1 = getRootNode1();
        boolean isMirror = findTreesAreMirror(root,root1);
        System.out.println(isMirror);
    }


    // expectations: traverse both the tree simultaneously and check child count of first child of left tree is equal to
    // child count of last child of right tree
    // faith: 20, 30, 40 will do its checking and return true or false. if false then return false without further traverse

    private static boolean findTreesAreMirror(Node1 root, Node1 root1) {
        if(root.children.size() != root1.children.size()){
            return false;
        }
        for(int i=0, j= root1.children.size()-1; i<root.children.size() && j >=0; i++, j--){
            boolean isSame = findTreesAreMirror(root.children.get(i), root1.children.get(j));
            if(!isSame) return false;
        }
        return true;
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

    private static Node1 getRootNode1() {
        Node1 c222 = new Node1(1120);
        Node1 c221 = new Node1(1110);
        Node1 c31 = new Node1(1100);
        Node1 c23 = new Node1(190);
        Node1 c22 = new Node1(180,Arrays.asList(c221,c222));
        Node1 c21 = new Node1(170);
        Node1 c12 = new Node1(160);
        Node1 c11 = new Node1(150);
        Node1 c3 = new Node1(140, Arrays.asList(c11,c12));
        Node1 c2 = new Node1(130, Arrays.asList(c21,c22,c23));
        Node1 c1 = new Node1(120,Arrays.asList(c31));
        Node1 root = new Node1(110, Arrays.asList(c1,c2,c3));

        return root;
    }

}
