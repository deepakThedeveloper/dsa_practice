package trees.bst;

import trees.BinaryTreeNode;

import java.util.*;

/*
You are given the root of a binary search tree and an array queries of size n consisting of positive integers.

Find a 2D array answer of size n where answer[i] = [mini, maxi]:

mini is the largest value in the tree that is smaller than or equal to queries[i]. If a such value does not exist, add -1 instead.
maxi is the smallest value in the tree that is greater than or equal to queries[i]. If a such value does not exist, add -1 instead.
 */
public class SuccessorAndPredecessor {
    public static void main(String[] args) {
        Map<Integer, Integer[]> map = new HashMap<>();
        for(Map.Entry<Integer, Integer[]> mp : map.entrySet()){

        }
        List<Integer> queries = Arrays.asList(2, 5, 16);
        BinaryTreeNode node = getTree();
        List<List<Integer>> data = new ArrayList<>();
        for(Integer v : queries) {
            List<Integer> val = new ArrayList<>();
            val.add(-1);
            val.add(-1);
            fun(node, v, Integer.MAX_VALUE, Integer.MAX_VALUE, val);
            data.add(val);
        }
        System.out.println(data);
    }

    private static void fun(BinaryTreeNode node, int k, int sDiff, int pDiff, List<Integer> val){
        if(node  == null) return;
        if(node.data== k){
            val.set(0,k);
            val.set(1,k);
        }
        else{
            if(k > node.data){
                int diff = k - node.data;
                if(sDiff > diff){
                    sDiff = diff;
                    val.set(0, node.data);
                }
                fun(node.right, k, sDiff, pDiff, val);
            }
            else{
                int diff = node.data - k;
                if(pDiff > diff){
                    pDiff = diff;
                    val.set(1, node.data);
                }
                fun(node.left, k, sDiff, pDiff, val);
            }
        }

    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode node0= new BinaryTreeNode(6);
        BinaryTreeNode node1= new BinaryTreeNode(2);
        BinaryTreeNode node2= new BinaryTreeNode(13);
        BinaryTreeNode node3= new BinaryTreeNode(1);
        BinaryTreeNode node4= new BinaryTreeNode(4);
        BinaryTreeNode node5= new BinaryTreeNode(9);
        BinaryTreeNode node6= new BinaryTreeNode(15);
        BinaryTreeNode node7= new BinaryTreeNode(14);

        node0.left=node1;
        node0.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node6.left=node7;

        return node0;
    }
}
