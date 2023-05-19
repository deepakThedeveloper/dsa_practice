package trees.todo;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeSerializeTree {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        System.out.println("Before serialization:");
        BinaryTreePrinter.print(node);
        System.out.println("========================");
        String serialize = serialize(node);
        System.out.println("Serialized:");
        System.out.println(serialize);
        System.out.println("========================");
        BinaryTreeNode node1 = deserialize(serialize);
        System.out.println("Deserialized:");
        BinaryTreePrinter.print(node1);

    }

    private static BinaryTreeNode deserialize(String serialize) {
        String[] nodeValues = serialize.split(",");
        BinaryTreeNode head = new BinaryTreeNode(Integer.parseInt(nodeValues[0].trim()));

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(head);
        for(int i=1; i < nodeValues.length - 2; i=i+2){
            BinaryTreeNode left = getNode(nodeValues[i]);
            BinaryTreeNode right = getNode(nodeValues[i+1]);

            BinaryTreeNode temp = queue.poll();
            if(temp==null)continue;
            temp.setLeft(left);
            temp.setRight(right);

            queue.add(left);
            queue.add(right);

        }
        return head;
    }

    private static BinaryTreeNode getNode(String val){
        String temp = val.trim();
        if(temp.equalsIgnoreCase("#") || temp.equalsIgnoreCase(" ")){
            return null;
        }
        return new BinaryTreeNode(Integer.parseInt(temp));
    }

    private static String serialize(BinaryTreeNode node) {
        Queue<BinaryTreeNode> vals = new LinkedList<>();
        vals.add(node);
        StringBuilder builder = new StringBuilder();

        while(!vals.isEmpty()){
            BinaryTreeNode node1 = vals.poll();
            builder.append(node1.getData()+", ");
            if(node1.getLeft()!=null){
                vals.add(node1.getLeft());
            }
            else{
                builder.append("#, ");
            }
            if(node1.getRight()!=null){
                vals.add(node1.getRight());
            }
            else{
                builder.append("#, ");
            }
        }
        return builder.toString();
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode root4 = new BinaryTreeNode(4);
        BinaryTreeNode root5 = new BinaryTreeNode(5);
        BinaryTreeNode root6 = new BinaryTreeNode(6);
        BinaryTreeNode root7 = new BinaryTreeNode(7);
        BinaryTreeNode root8 = new BinaryTreeNode(8);
        BinaryTreeNode root9 = new BinaryTreeNode(9);
        BinaryTreeNode root10 = new BinaryTreeNode(10);
        BinaryTreeNode root11 = new BinaryTreeNode(11);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root4);
        root1.setRight(root5);
        root2.setLeft(root6);
        root2.setRight(root7);
        root4.setLeft(root8);
        root4.setRight(root9);
        root5.setLeft(root10);
        root5.setRight(root11);

        return root;
    }
}
