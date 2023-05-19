package recursion;

import lombok.AllArgsConstructor;

public class RecursivelyDeleteKthNodeFromLL {
    public static void main(String[] args) {
        Node node = new Node(1,null);
        Node node1 = new Node(2,node);
        Node node2 = new Node(3,node1);
        Node node3 = new Node(4,node2);
        Node node4 = new Node(5,node3);
        Node node5 = new Node(6,node4);
        Node node6 = new Node(7,node5);
        Node head = new Node(8,node6);

        Node head1 = head;
        int k = 5;
        deleteKthNode(head, k, 1);

        while (head1!=null){
            System.out.print(head1.val);
            head1 = head1.next;
        }
    }

    private static void deleteKthNode(Node node, int k, int count) {
        if(node==null || count == k) return;

        deleteKthNode(node.next, k, count+1);
        if(count+1 == k && node.next!=null){
            node.next = node.next.next;
        }
    }
}

@AllArgsConstructor
class Node{
    int val;
    Node next;
}
