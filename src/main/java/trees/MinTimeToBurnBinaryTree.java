package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinTimeToBurnBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();

        BinaryTreePrinter.print(node);
        int target = 2;
        Map<BinaryTreeNode, BinaryTreeNode> parentLinks = new HashMap<>();

        createParentNodeLinks(node, node, parentLinks);
        BinaryTreeNode targetNode = getTargetNode(target, node);
        traverseKNode(targetNode, parentLinks);
    }

    private static void traverseKNode(BinaryTreeNode node, Map<BinaryTreeNode, BinaryTreeNode> parentLinks) {
        Map<BinaryTreeNode, Boolean> visited = new HashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        int timeNeeded = 0;
        queue.add(node);
        visited.put(node, true);
        while(!queue.isEmpty()){
            boolean burned = false;

            int size = queue.size();
            System.out.println(timeNeeded+", "+ size);

            for(int i=0; i<size; i++){
                BinaryTreeNode currNode = queue.poll();
                if(currNode.getLeft()!=null && !visited.containsKey(currNode.getLeft())){
                    burned = true;
                    queue.add(currNode.getLeft());
                    visited.put(currNode.getLeft(), true);
                }
                if(currNode.getRight()!=null && !visited.containsKey(currNode.getRight())){
                    burned = true;
                    queue.add(currNode.getRight());
                    visited.put(currNode.getRight(), true);
                }
                if(parentLinks.containsKey(currNode) && !visited.containsKey(parentLinks.get(currNode))){
                    burned = true;
                    queue.add(parentLinks.get(currNode));
                    visited.put(parentLinks.get(currNode), true);
                }
            }
            if(burned){
                timeNeeded++;
            }
        }
        System.out.println("time needed to burn tree:"+timeNeeded);
    }

    private static BinaryTreeNode getTargetNode(int target, BinaryTreeNode node){
        if(node == null) return null;

        if(node.getData() == target) return node;
        BinaryTreeNode left = getTargetNode(target, node.getLeft());
        BinaryTreeNode right = getTargetNode(target, node.getRight());

        if(left == null) return right;
        if(right == null) return left;

        return left;
    }
    private static void createParentNodeLinks(BinaryTreeNode node, BinaryTreeNode parent, Map<BinaryTreeNode, BinaryTreeNode> parentLinks) {
        if(node == null) return;
        parentLinks.put(node, parent);
        createParentNodeLinks(node.getLeft(), node, parentLinks);
        createParentNodeLinks(node.getRight(), node, parentLinks);
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode root1 = new BinaryTreeNode(2);
        BinaryTreeNode root2 = new BinaryTreeNode(3);
        BinaryTreeNode root3 = new BinaryTreeNode(4);
        BinaryTreeNode root4 = new BinaryTreeNode(5);
        BinaryTreeNode root5 = new BinaryTreeNode(6);
        BinaryTreeNode root6 = new BinaryTreeNode(7);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root3);
        root3.setRight(root6);
        root2.setLeft(root4);
        root2.setRight(root5);

        return root;
    }
}
