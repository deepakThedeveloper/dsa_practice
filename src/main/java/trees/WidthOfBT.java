package trees;

import lombok.AllArgsConstructor;
import trees.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WidthOfBT {
    public static void main(String[] args) {
        BinaryTreeNode root = getTree();
        int width = maxWidth(root);
        System.out.println("width:"+width);
    }

    private static int maxWidth(BinaryTreeNode node){
        Queue<NodeData> queue = new LinkedList<>();
        queue.add(new NodeData(node, 0));

        int width = 1;
        while(!queue.isEmpty()){
            int size = queue.size();

            int min = Integer.MAX_VALUE;
            int tempWidth = 0;
            for(int i=0; i<size; i++){
                NodeData node1 = queue.poll();
                BinaryTreeNode node2 = node1.node;

                min = Math.min(min, node1.level);
                tempWidth = (node1.level-min)+1;
                if(node2.left!=null){
                    queue.add(new NodeData(node2.left, 2*(node1.level-min)+1));
                }
                if(node2.right!=null){
                    queue.add(new NodeData(node2.right, 2*(node1.level-min)+2));
                }
            }
            width = Math.max(width, tempWidth);
        }
        return width;
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root0 = new BinaryTreeNode(0);
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);

        root0.setLeft(root1);
        root0.setRight(root2);
        root1.setLeft(root3);
        root2.setRight(root4);
        root3.setLeft(root5);
        root4.setRight(root6);

        return root0;
    }


    @AllArgsConstructor
    static class NodeData{
        BinaryTreeNode node;
        int level;
    }

}
