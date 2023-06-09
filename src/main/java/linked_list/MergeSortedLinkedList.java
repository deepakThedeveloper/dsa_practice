package linked_list;

import java.util.Stack;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        Node1 node1 = new Node1(10);
        Node1 node2 = new Node1(8, node1);
        Node1 node3 = new Node1(6, node2);
        Node1 node4 = new Node1(4, node3);
        Node1 node5 = new Node1(2, node4);

        Node1 node33 = new Node1(5);
        Node1 node44 = new Node1(3, node33);
        Node1 node55 = new Node1(1, node44);

        Node1 newNode = mergeList(node5, node55);
        while(newNode!=null){
            System.out.print(newNode.val+"-->");
            newNode = newNode.next;
        }
    }

    private static Node1 mergeList(Node1 head1, Node1 head2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        while(head1!=null || head2 != null){
            if(head1!=null){
                st1.push(head1.val);
                head1 = head1.next;
            }

            if(head2!=null){
                st2.push(head2.val);
                head2 = head2.next;
            }
        }

       return getNewNode(st1, st2);
    }

    private static Node1 getNewNode(Stack<Integer> st1, Stack<Integer> st2){
        Node1 head = null;
        Node1 head1 = null;

        while(!st1.isEmpty() && !st2.isEmpty()){
            Node1 node1 = null;
            if(st1.peek() > st2.peek()){
               node1 = new Node1(st1.pop());
            }
            else{
               node1 = new Node1(st2.pop());
            }
            if(head == null){
                head = node1;
                head1 = head;
            }
            else{
                head.next = node1;
                head = head.next;
            }
        }

        while(!st1.isEmpty()){
            Node1 node1 = new Node1(st1.pop());
            head.next = node1;
            head = head.next;
        }
        while(!st2.isEmpty()){
            Node1 node1 = new Node1(st2.pop());
            head.next = node1;
            head = head.next;
        }

        return head1;
    }
}
