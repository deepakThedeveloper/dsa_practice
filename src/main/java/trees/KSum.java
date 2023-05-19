package trees;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class KSum {
    public static void main(String[] args) {
        BinaryTreeNode BinaryTreeNode = getTree();
        BinaryTreePrinter.print(BinaryTreeNode);
        Count count = new Count(0);
        kSum(BinaryTreeNode, 5, count, new ArrayList<>());
        System.out.println(count.count);
    }
    @AllArgsConstructor
    static class Count{
        int count;
    }

    private static void kSum(BinaryTreeNode node, int target, Count count, List<Integer> path) {
        if(node == null){
            return;
        }
        path.add(node.data);

        int sum = 0;
        for(int i = path.size()-1; i>=0; i--){
            System.out.println("in for");
            sum += path.get(i);
            if(sum == target){
                count.count++;
                //break;
            }
        }

        kSum(node.getLeft(), target, count, path);
        kSum(node.getRight(), target, count, path);


        path.remove(path.size()-1);
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode mid6 = new BinaryTreeNode(6);
        BinaryTreeNode mid7 = new BinaryTreeNode(7);
        BinaryTreeNode mid8 = new BinaryTreeNode(8);
        BinaryTreeNode mid9 = new BinaryTreeNode(9);
        BinaryTreeNode mid5 = new BinaryTreeNode(5);
        BinaryTreeNode mid4 = new BinaryTreeNode(4);
        BinaryTreeNode mid2 = new BinaryTreeNode(2);
        BinaryTreeNode mid3 = new BinaryTreeNode(3);
        BinaryTreeNode root = new BinaryTreeNode(1);

        mid5.left = mid6;
        mid5.right = mid7;
        mid4.left = mid8;
        mid4.right = mid9;
        mid3.left = mid4;
        mid3.right = mid5;
        root.left = mid2;
        root.right = mid3;

        return root;
    }
}