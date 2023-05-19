package trees.view;

import lombok.AllArgsConstructor;
import trees.Node;

import java.util.*;

public class TopBottomLeftView {
    public static void main(String[] args) {
        Node root = getTree();
        topView(root);
        System.out.println("bottom view:-------------------------");
        bottomView(root);
        System.out.println();
        System.out.println("left view:-------------------------");
        Map<Integer, Integer> map = new HashMap<>();
        leftView(root, 0, map);
        System.out.println(map.values());
    }

    @AllArgsConstructor
    static class Data{
        Node node;
        int level;
    }
    private static void topView(Node root) {
        Queue<Data> nodes = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();

        nodes.add(new Data(root, 0));
        map.put(0, root.val);

        while (!nodes.isEmpty()){
            Data data = nodes.poll();
            Node node = data.node;
            if(node.left!=null) {
                int level = data.level-1;
                nodes.add(new Data(node.left, level));
                if(!map.containsKey(level))
                    map.put(level, node.left.val);
            }
            if(node.right!=null) {
                int level = data.level+1;
                nodes.add(new Data(node.right, level));
                if(!map.containsKey(level))
                    map.put(level, node.right.val);
            }
        }

        for(Integer val : map.values()){
            System.out.print(val);
        }
    }

    private static void bottomView(Node root){
        Queue<Data> nodes = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();

        nodes.add(new Data(root, 0));
        map.put(0, root.val);

        while (!nodes.isEmpty()){
            Data data = nodes.poll();
            Node node = data.node;
            if(node.left!=null) {
                int level = data.level-1;
                nodes.add(new Data(node.left, level));
                //if(map.containsKey(level))
                    map.put(level, node.left.val);
            }
            if(node.right!=null) {
                int level = data.level+1;
                nodes.add(new Data(node.right, level));
                //if(!map.containsKey(level))
                    map.put(level, node.right.val);
            }
        }

        for(Integer val : map.values()){
            System.out.print(val+",");
        }
    }

    private static void leftView(Node root, int level, Map<Integer, Integer> map){
        if(root == null)return;
        if(!map.containsKey(level)){
            map.put(level, root.val);
        }
        leftView(root.left, level+1, map);
        leftView(root.right, level+1, map);
    }

    private static Node getTree(){
        Node leaf9 = new Node(9);
        Node leaf8 = new Node(10);
        Node mid3 = new Node(4);
        Node mid4 = new Node(5);
        Node mid1 = new Node(2, mid3, mid4);

        Node mid5 = new Node(6);
        Node mid6 = new Node(7);
        Node mid2 = new Node(3, mid5, mid6);
        Node mid7 = new Node(8);
        mid4.left = mid7;
        mid5.left = leaf9;
        leaf9.left = leaf8;
        Node root = new Node(1, mid1, mid2);

        return root;
    }
}
