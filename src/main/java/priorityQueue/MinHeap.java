package priorityQueue;

import lombok.val;

public class MinHeap {
    Node node;

    public void insert(int val){
        Node newNode = new Node(val);
        node.right = newNode;

    }

    private void bubbleUp(Node newNode, Node parent) {
        if(parent.getVal() > newNode.getVal()){
            newNode.left = parent.left;
            newNode.right = parent;
            parent.left = null;
            parent.right = null;
        }

    }

    /*public Node poll(){

    }

    public Node remove(int val){

    }

    public Node peek(){

    }*/
}
