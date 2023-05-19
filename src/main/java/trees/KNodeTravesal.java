package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KNodeTravesal {
    public static void main(String[] args) {
        Node node = getTree();

        int target = 5;
        int k = 3;
        Map<Node, Node> parentLinks = new HashMap<>();

        createParentNodeLinks(node, node, parentLinks);
        Node targetNode = getTargetNode(target, node);
        traverseKNode(targetNode, k, parentLinks);
    }

    private static void traverseKNode(Node node, int k, Map<Node, Node> parentLinks) {
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        int curLevel = 0;
        queue.add(node);
        visited.put(node, true);
        while(!queue.isEmpty()){
            if(curLevel == k) break;
            curLevel++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node currNode = queue.poll();
                if(currNode.left!=null && !visited.containsKey(currNode.left)){
                    queue.add(currNode.left);
                    visited.put(currNode.left, true);
                }
                if(currNode.right!=null && !visited.containsKey(currNode.right)){
                    queue.add(currNode.right);
                    visited.put(currNode.right, true);
                }
                if(parentLinks.containsKey(currNode) && !visited.containsKey(parentLinks.get(currNode))){
                    queue.add(parentLinks.get(currNode));
                    visited.put(parentLinks.get(currNode), true);
                }
            }
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll().val);
        }
    }

    private static Node getTargetNode(int target, Node node){
        if(node == null) return null;

        if(node.val == target) return node;
        Node left = getTargetNode(target, node.left);
        Node right = getTargetNode(target, node.right);

        if(left == null) return right;
        if(right == null) return left;

        return left;
    }
    private static void createParentNodeLinks(Node node, Node parent, Map<Node, Node> parentLinks) {
        if(node == null) return;
        parentLinks.put(node, parent);
        createParentNodeLinks(node.left, node, parentLinks);
        createParentNodeLinks(node.right, node, parentLinks);
    }

    private static Node getTree(){
        Node mid6 = new Node(4);
        Node mid7 = new Node(7);
        Node mid8 = new Node(8);
        Node mid9 = new Node(0);
        Node mid5 = new Node(2, mid7, mid6);
        Node mid4 = new Node(6);
        Node mid2 = new Node(5, mid4, mid5);

        Node mid3 = new Node(1, mid9, mid8);
        Node root = new Node(3, mid2, mid3);

        return root;
    }
}
