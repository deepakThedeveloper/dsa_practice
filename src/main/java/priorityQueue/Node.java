package priorityQueue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Node {
    public  int val;
    Node(int val){
        this.val = val;
    }
    Node left, right;

    public void postorderDisplay(Node node){
        if(node == null) return;

        postorderDisplay(node.left);
        postorderDisplay(node.right);
        System.out.print(node.val+",");
    }

    public void inorderDisplay(Node node){
        if(node == null) return;

        inorderDisplay(node.left);
        System.out.print(node.val+",");
        inorderDisplay(node.right);
    }

    public void preorderDisplay(Node node){
        if(node == null) return;

        System.out.print(node.val+",");
        preorderDisplay(node.left);
        preorderDisplay(node.right);
    }
}
