package trees;

import lombok.AllArgsConstructor;
import lombok.Setter;

//tree is called balanced binary tree if ht of its left child minus height of its right child is <=1
public class IsItBalancedBinaryTree {
    public static void main(String[] args) {
        Node invalidTree = getInvalidBBT();
        Data1 data1 = isItBBT(invalidTree);
        System.out.println("ht:"+data1.ht+" valid:"+data1.valid);
       /* Node validTree = getValidBBT();
        Data1 data1 = isItBBT(validTree);
        System.out.println("ht:"+data1.ht+" valid:"+data1.valid);*/

    }

    private static Node getInvalidBBT() {
        Node node6 = new Node(70);
        Node node5 = new Node(60);
        Node node4 = new Node(50, null, node6);
        Node node3 = new Node(40, node5, null);
        Node node2 = new Node(30, null, node4);
        Node node1 = new Node(20, node3, null);
        Node root = new Node(10, node1, node2);

        return root;
    }

    private static Node getValidBBT() {
        Node node4 = new Node(50);
        Node node3 = new Node(40);
        Node node2 = new Node(30, null, node4);
        Node node1 = new Node(20, node3, null);
        Node root = new Node(10, node1, node2);

        return root;
    }

    private static Data1 isItBBT(Node node){
        if(node == null){
            return new Data1(0, true);
        }
        Data1 ldata = isItBBT(node.left);
        if(!ldata.valid){
            System.out.println("failure node:"+node.val);
            ldata.setHt(ldata.ht+1);
            return ldata;
        }
        Data1 rdata = isItBBT(node.right);
        if(!rdata.valid){
            System.out.println("failure node:"+node.val);
            rdata.setHt(rdata.ht+1);
            return rdata;
        }

        int ht = Math.abs(ldata.ht - rdata.ht);
        if(ht ==1 || ht==0){
            return new Data1(Math.max(ldata.ht, rdata.ht)+1, true);
        }
        else{
            return new Data1(Math.max(ldata.ht, rdata.ht)+1, false);
        }
    }
}

@AllArgsConstructor
@Setter
class Data1{
    int ht;
    boolean valid;
}
