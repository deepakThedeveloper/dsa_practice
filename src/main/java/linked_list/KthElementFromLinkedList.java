package linked_list;

public class KthElementFromLinkedList {
    public static void main(String[] args) {
        Node1 node1 = new Node1(1);
        Node1 node2 = new Node1(2, node1);
        Node1 node3 = new Node1(3, node2);
        Node1 node4 = new Node1(4, node3);
        Node1 node5 = new Node1(5, node4);
        Node1 node6 = new Node1(6, node5);
        Node1 head = new Node1(7, node6);

        int k=0;

        Integer val = findKthElement(head, k);
        System.out.println(val);
    }
// p2 = 4
// p1 =
// count = 5
// k     = 3
    private static Integer findKthElement(Node1 head, int k) {
       Node1 p1 = head;
       Node1 p2 = head;

       int count  = 1;
       while(p2.next!=null){
           if(count >= k){
               p1 = p1.next;
           }
           p2 = p2.next;
           count++;
       }
       if(count < k){
           return -1;
       }
       return p1.val;
    }
}
