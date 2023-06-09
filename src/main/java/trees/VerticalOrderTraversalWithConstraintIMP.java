package trees;

import javafx.util.Pair;
import lombok.AllArgsConstructor;

import java.util.*;

public class VerticalOrderTraversalWithConstraintIMP {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        Map<Integer, List<Integer>> map = verticalTraverseWithConstraint(node);
        System.out.println(map);
    }

    private static Map<Integer, List<Integer>> verticalTraverseWithConstraint(BinaryTreeNode node){
        Map<Integer, List<Integer>> result = new HashMap<>();
        PriorityQueue<NodeData> parent = new PriorityQueue<>(Comparator.comparingInt(v->v.node.data));
        PriorityQueue<NodeData> child = new PriorityQueue<>(Comparator.comparingInt(v->v.node.data));

        int rootNodeLevel = 0;
        parent.add(new NodeData(node, rootNodeLevel));

        while(!parent.isEmpty()){
            NodeData data = parent.poll();
            BinaryTreeNode node1 = data.node;
            if(result.containsKey(data.level)){
                result.get(data.level).add(node1.data);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(node1.data);
                result.put(data.level, list);
            }

            if(node1.left!=null) child.add(new NodeData(node1.left, data.level-1));

            if(node1.right!=null) child.add(new NodeData(node1.right, data.level+1));

            if(parent.isEmpty()){
                PriorityQueue<NodeData> temp = parent;
                parent = child;
                child = temp;
            }
        }
        return result;
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root0 = new BinaryTreeNode(7);
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode root2 = new BinaryTreeNode(9);
        BinaryTreeNode root3 = new BinaryTreeNode(1);
        BinaryTreeNode root4 = new BinaryTreeNode(3);
        BinaryTreeNode root5 = new BinaryTreeNode(2);
        BinaryTreeNode root6 = new BinaryTreeNode(11);
        BinaryTreeNode root7 = new BinaryTreeNode(6);
        BinaryTreeNode root8 = new BinaryTreeNode(7);
        BinaryTreeNode root9 = new BinaryTreeNode(6);
        BinaryTreeNode root10 = new BinaryTreeNode(4);
        BinaryTreeNode root11 = new BinaryTreeNode(19);
        BinaryTreeNode root12 = new BinaryTreeNode(1);
        BinaryTreeNode root13 = new BinaryTreeNode(-10);
        BinaryTreeNode root14 = new BinaryTreeNode(10);
        BinaryTreeNode root15 = new BinaryTreeNode(20);
        BinaryTreeNode root16 = new BinaryTreeNode(21);

        root0.setLeft(root1);
        root0.setRight(root2);
        root1.setLeft(root3);
        root1.setRight(root4);
        root2.setLeft(root5);
        root2.setRight(root6);
        root3.setLeft(root7);
        root3.setRight(root8);
        root4.setLeft(root9);
        root4.setRight(root11);
        root5.setLeft(root10);
        root5.setRight(root12);
        root6.setLeft(root13);
        root6.setRight(root14);
        root10.setRight(root15);
        root14.setRight(root16);

        return root0;
    }
}


@AllArgsConstructor
class NodeData{
    BinaryTreeNode node;
    int level;
}
