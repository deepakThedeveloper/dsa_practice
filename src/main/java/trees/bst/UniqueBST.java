package trees.bst;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {
    public static void main(String[] args) {
        List<BinaryTreeNode> list = test(1, 3);
        list.forEach(BinaryTreePrinter::print);
    }
    private static List<BinaryTreeNode> test(int l, int n){
        List<BinaryTreeNode> lst = new ArrayList<>();
        if(l>n) {
            lst.add(null);
            return lst;
        }

        for(int i=l; i<=n; i++){
            List<BinaryTreeNode> left = test(l, i-1);
            List<BinaryTreeNode> right = test(i+1, n);

            for(BinaryTreeNode lft : left){
                for(BinaryTreeNode rt : right){
                    BinaryTreeNode node = new BinaryTreeNode(i);
                    node.left = lft;
                    node.right = rt;

                    lst.add(node);
                }
            }

        }
        return lst;
    }
}
