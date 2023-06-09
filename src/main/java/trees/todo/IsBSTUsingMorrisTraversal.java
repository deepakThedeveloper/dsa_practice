package trees.todo;

import javafx.util.Pair;
import trees.BinaryTreeNode;

//todo
public class IsBSTUsingMorrisTraversal {
    public static void main(String[] args) {

    }

    private static BinaryTreeNode isBst(BinaryTreeNode node){

        BinaryTreeNode prev = node;
        while(node.left!=null) {
            node = node.left;
        }
        while(node.right!=null){
            node = node.right;
        }
        return null;
    }
}
