package recursion;

import linked_list.Node1;

public class AdditionOf2LinkedList {
    public static void main(String[] args) {
        Node1 node1 = new Node1(6);
        Node1 node2 = new Node1(7, node1);
        Node1 node3 = new Node1(9, node2);
        Node1 head = new Node1(9, node3);

        Node1 node11 = new Node1(7);
        Node1 head1 = new Node1(8, node11);

        int finalRemainder = addLinkedList(head, 4, head1, 2);
        Node1 node12 = new Node1(finalRemainder);
        node12.next = newHead;
        newHead = node12;
        while(newHead!=null) {
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }

    static Node1 newHead = null;

    private static Node1 getNode(int remainder, Node1 res){
        int rem = remainder % 10;
        Node1 newNode = new Node1(rem);
        if(res == null){
            res = newNode;
        }
        else{
            newNode.next = res;
            return newNode;
        }
        return res;
    }
    private static int addLinkedList(Node1 head, int size1,  Node1 head1, int size2) {
        if(head == null && head1== null) return 0;
        if(size1 > size2){
            int remainder = addLinkedList(head.next, size1-1, head1, size2);
            remainder = remainder + head.val;
            newHead = getNode(remainder, newHead);
            return remainder /10;
        }
        else if(size2 > size1){
            int remainder = addLinkedList(head, size1, head1.next, size2-1);
            remainder = remainder + head1.val;
            newHead = getNode(remainder, newHead);
            return remainder /10;
        }
        else {
            int remainder = addLinkedList(head.next, size1 - 1, head1.next, size2 - 1);
            remainder = head.val + head1.val + remainder;
            newHead = getNode(remainder, newHead);
            return remainder / 10;
        }
    }
}

/*
*   9  9  9  9
*         1  1
*-------------
* 1  0  0  1  0
*
*
* return from method will be node object
* reach end of both the linked list. once reached return null;
* add last two objects val,. create nodes based on number of digits of sum.
* for previous one
* */
