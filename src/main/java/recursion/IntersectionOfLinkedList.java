package recursion;

import linked_list.Node1;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        Node1 node1 = new Node1(6);
        Node1 node2 = new Node1(17, node1);
        Node1 node3 = new Node1(18, node2);
        Node1 node4 = new Node1(28, node3);
        Node1 node5 = new Node1(38, node4);
        Node1 head = new Node1(9, node5);

        Node1 node12 = new Node1(18, node2);
        Node1 head1 = new Node1(19, node12);

        int intersection = findIntersection(head, 6, head1, 4);
        System.out.println(intersection);
    }

    private static int findIntersection(Node1 head, int s1, Node1 head1, int s2) {
        if(head == null && head1 == null) return -1;
        if(s1 > s2){
            return findIntersection(head.next, s1-1, head1, s2);
        }
        else if(s2 > s1){
            return findIntersection(head, s1, head1.next, s2-1);
        }
        else{
            Node1 newHead = head;
            Node1 newHead1 = head1;
            if(newHead == newHead1){
                return newHead.val;
            }
            return findIntersection(head.next, s1-1, head1.next, s2-1);
        }
    }
}
