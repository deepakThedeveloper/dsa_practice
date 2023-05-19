package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
public class PopulateNextPointer {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    
    public static void main(String[] args) {
        Node node = getTree();
        connect(node);
    }
    public static Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                if(node.left != null)  queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(i == size-1) node.next = null;
                else node.next = queue.peek();
            }
        }
        return root;
    }
    
    private static Node getTree(){
        Node root = new Node(1);
        Node root1 = new Node(2);
        Node root2 = new Node(3);
        Node root3 = new Node(4);
        Node root4 = new Node(5);
        Node root5 = new Node(7);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.right = root5;

        return root;
    }
}
