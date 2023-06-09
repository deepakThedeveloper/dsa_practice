package trees;

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
        serializePreorder(node);
        String serialized = builder.toString();
        System.out.println("Serialized:"+serialized);
        System.out.println("========================");
        BinaryTreeNode node1 = deserializePreorder(serialized);
        System.out.println("Deserialized:");
        BinaryTreePrinter.print(node1);

    }

    private static BinaryTreeNode deserializePreorder(String serialize) {
        String[] nodeValues = serialize.split(",");
        return deserialize(nodeValues);
    }

    static int idx = 0;
    private static BinaryTreeNode deserialize(String[] arr){
        if(idx==arr.length || arr[idx].equals("#")){
            idx++;
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);

        return node;
    }

    private static StringBuilder builder = new StringBuilder();
    private static void serializePreorder(BinaryTreeNode node){
        if(node == null){
            builder.append("#,");
            return;
        }
        builder.append(node.getData()).append(",");
        serializePreorder(node.left);
        serializePreorder(node.right);
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
