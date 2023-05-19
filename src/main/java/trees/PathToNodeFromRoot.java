package trees;

import java.util.ArrayList;

public class PathToNodeFromRoot {
    public static void main(String[] args) {
        Node node = getTree();

        ArrayList<Integer> paths = new ArrayList<>();
        getPath(node, paths, 8);
        //System.out.println(paths);
    }

    private static void getPath(Node node, ArrayList<Integer> paths, int val) {
        if(node == null) return;

        paths.add(node.val);
        if(node.val == val){
            System.out.println(paths);
            return;
        }
        getPath(node.left, paths, val);
        getPath(node.right, paths, val);
        paths.remove(paths.size()-1);
    }

    private static Node getTree(){
        Node mid6 = new Node(6);
        Node mid7 = new Node(7);
        Node mid8 = new Node(8);
        Node mid9 = new Node(9);
        Node mid5 = new Node(5);
        Node mid4 = new Node(4, mid6, mid8);
        Node mid2 = new Node(2, mid4, mid5);

        Node mid3 = new Node(3);
        mid3.left=mid9;
        mid9.right = mid8;
        Node root = new Node(1, mid2, mid3);

        return root;
    }

}
